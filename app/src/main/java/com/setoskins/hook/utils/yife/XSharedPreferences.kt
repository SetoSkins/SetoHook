package com.setoskins.hook.utils.yife

import com.setoskins.hook.BuildConfig.APPLICATION_ID
import de.robv.android.xposed.XSharedPreferences

/**
 * XSharedPreferences 工具
 */
object XSharedPreferences {
    /**
     * XSharedPreferences 文件名
     */
    const val prefFileName = "config"
    private val prefs = XSharedPreferences(APPLICATION_ID, "config")

    /**
     * 获取对应的 Boolean 属性值
     * @param key 属性名称
     * @param defValue 默认值
     */
    fun getBoolean(key: String, defValue: Boolean): Boolean {
        if (prefs.hasFileChanged()) {
            prefs.reload()
        }
        return prefs.getBoolean(key, defValue)
    }

    /**
     * 获取对应的 Int 属性值
     * @param key 属性名称
     * @param defValue 默认值
     */
    fun getInt(key: String, defValue: Int): Int {
        if (prefs.hasFileChanged()) {
            prefs.reload()
        }
        return prefs.getInt(key, defValue)
    }

    /**
     * 获取对应的 String 属性值
     * @param key 属性名称
     * @param defValue 默认值
     */
    fun getString(key: String, defValue: String): String {
        if (prefs.hasFileChanged()) {
            prefs.reload()
        }
        return prefs.getString(key, defValue) ?: defValue
    }

    /**
     * 获取对应的 StringSet 属性值
     * @param key 属性名称
     * @param defValue 默认值
     */
    fun getStringSet(key: String, defValue: MutableSet<String>): MutableSet<String> {
        if (prefs.hasFileChanged()) {
            prefs.reload()
        }
        return prefs.getStringSet(key, defValue) ?: defValue
    }
}
