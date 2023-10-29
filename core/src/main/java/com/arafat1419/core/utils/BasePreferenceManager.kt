package com.arafat1419.core.utils

import android.content.Context
import android.content.SharedPreferences
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import java.nio.charset.StandardCharsets
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

open class BasePreferenceManager(private val prefName: String) {
    private lateinit var preferences: SharedPreferences
    protected val editor: SharedPreferences.Editor by lazy {
        preferences.edit()
    }

    fun initialize(context: Context) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

        generateKey()
    }

    protected fun encryptPreference(key: String, value: String) {
        try {
            val keyStore = KeyStore.getInstance("AndroidKeyStore")
            keyStore.load(null)
            val secretKey = keyStore.getKey(KEY_ALIAS, null) as SecretKey

            val cipher = Cipher.getInstance(TRANSFORMATION)
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            val iv = cipher.iv

            val encryptedBytes = cipher.doFinal(value.toByteArray(StandardCharsets.UTF_8))
            val encryptedValue = Base64.encodeToString(encryptedBytes, Base64.DEFAULT)

            editor.putString(key, encryptedValue)
            editor.putString(key + "_iv", Base64.encodeToString(iv, Base64.DEFAULT))
            editor.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    protected fun decryptPreference(key: String): String? {
        try {
            val keyStore = KeyStore.getInstance("AndroidKeyStore")
            keyStore.load(null)
            val secretKey = keyStore.getKey(KEY_ALIAS, null) as SecretKey

            val encryptedValue = preferences.getString(key, null)
            val ivValue = preferences.getString(key + "_iv", null)

            if (encryptedValue != null && ivValue != null) {
                val cipher = Cipher.getInstance(TRANSFORMATION)
                val iv = Base64.decode(ivValue, Base64.DEFAULT)
                val ivParams = IvParameterSpec(iv)
                cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParams)

                val decodedBytes = Base64.decode(encryptedValue, Base64.DEFAULT)
                val decryptedBytes = cipher.doFinal(decodedBytes)
                return String(decryptedBytes, StandardCharsets.UTF_8)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    private fun generateKey() {
        try {
            val keyStore = KeyStore.getInstance("AndroidKeyStore")
            keyStore.load(null)

            if (!keyStore.containsAlias(KEY_ALIAS)) {
                val keyGenerator =
                    KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
                keyGenerator.init(
                    KeyGenParameterSpec.Builder(
                        KEY_ALIAS,
                        KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
                    )
                        .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                        .setUserAuthenticationRequired(false)
                        .build()
                )
                keyGenerator.generateKey()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val TRANSFORMATION = "AES/CBC/PKCS7Padding"
        private const val KEY_ALIAS = "M3D1C@LK3Y4L1@S"
    }
}