package com.arafat1419.medcheck.utils

import com.arafat1419.core.utils.BasePreferenceManager

object PreferenceManager : BasePreferenceManager("medcheck_pref") {
    fun clearAllData() {
        editor.clear()
        editor.commit()
    }

    fun saveToken(token: String) {
        encryptPreference(TOKEN, token)
    }

    fun getToken(): String? = decryptPreference(TOKEN)

    private const val TOKEN = "token"
}