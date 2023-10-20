package com.setoskins.hook.hook.hooks.android

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedBridge.hookAllMethods

object BoostCameraIfNeeded : BaseHook() {
    override fun init() {
        loadClass("com.android.server.am.CameraBooster").methodFinder()
            .filterByName("boostCameraIfNeeded").first().createHook {
                before { param ->
                    param.result = null
                }
            }
    }
}