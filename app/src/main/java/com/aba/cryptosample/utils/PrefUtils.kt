package com.aba.cryptosample.utils

import android.content.Context
import android.preference.PreferenceManager
import com.aba.cryptosample.AppConstants

class PrefUtils {

    companion object {
        const val PREFS_PASSWORD = "PREFS_PASSWORD"


        fun getPassword(context: Context) : String {
            return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREFS_PASSWORD , AppConstants.DEFAULT_PASSWORD)!!
        }

        fun setPassword(context: Context , password : String) {
            PreferenceManager.getDefaultSharedPreferences(context)
                .edit().putString(PREFS_PASSWORD , password).apply()
        }
    }
}