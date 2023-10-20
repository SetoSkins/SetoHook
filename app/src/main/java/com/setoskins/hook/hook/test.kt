package com.setoskins.hook.hook

import com.github.kyuubiran.ezxhelper.ClassUtils

val SettingsFeaturesCls by lazy {
    ClassUtils.loadClass("com.android.settings.utils.SettingsFeatures")
}
val MiuiBuildCls by lazy {
    ClassUtils.loadClass("miui.os.Build")
}