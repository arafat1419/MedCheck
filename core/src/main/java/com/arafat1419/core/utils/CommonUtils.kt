package com.arafat1419.core.utils

import android.util.Patterns
import androidx.compose.ui.text.input.KeyboardType

object CommonUtils {
    fun isValidInput(input: String, keyboardType: KeyboardType, isAllowEmpty: Boolean): String? {
        if (!isAllowEmpty && (input == "")) {
            return "Data tidak boleh kosong"
        }

        return when (keyboardType) {
            KeyboardType.Email -> if (!Patterns.EMAIL_ADDRESS.matcher(input)
                    .matches()
            ) "Email tidak valid" else null

            KeyboardType.Number -> if (!input.matches(Regex("^[0-9]*\$"))) "Angka tidak valid" else null
            KeyboardType.Phone -> if (!Regex("^\\+?[0-9]*\$").matches(input)) "Nomor Telepon tidak valid" else null

            else -> null
        }
    }
}