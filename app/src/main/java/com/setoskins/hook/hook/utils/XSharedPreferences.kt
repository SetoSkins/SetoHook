package com.setoskins.hook.hook.utils

import com.setoskins.hook.BuildConfig
import de.robv.android.xposed.XSharedPreferences

object XSharedPreferences {
    fun getBoolean(key: String, defValue: Boolean): Boolean {
        val prefs = XSharedPreferences(BuildConfig.APPLICATION_ID, "config")
        if (prefs.hasFileChanged()) {
            prefs.reload()
        }
        return prefs.getBoolean(key, defValue)
    }

    fun getString(key: String, defValue: String): String {
        val prefs = XSharedPreferences(BuildConfig.APPLICATION_ID, "config")
        if (prefs.hasFileChanged()) {
            prefs.reload()
        }
        return prefs.getString(key, defValue) ?: defValue
    }

    fun getStringSet(key: String, defValue: MutableSet<String>): MutableSet<String> {
        val prefs = XSharedPreferences(BuildConfig.APPLICATION_ID, "config")
        if (prefs.hasFileChanged()) {
            prefs.reload()
        }
        return prefs.getStringSet(key, defValue) ?: defValue
    }

}