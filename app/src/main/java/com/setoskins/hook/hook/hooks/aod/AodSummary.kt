package com.setoskins.hook.hook.hooks.aod

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge

object AodSummary : BaseHook() {
    override fun init() {
        XposedBridge.log("SetoHook：AOD Hook 开始(共四段 第一段)")
        loadClass("com.miui.aod.widget.AODSettings").methodFinder()
            .filterByName("onlySupportKeycodeGoto").first()
            .createHook {
                returnConstant(false)
            }
        XposedBridge.log("SetoHook：AOD Hook 开始(共四段 第二段)")
        loadClass("com.miui.aod.doze.MiuiDozeScreenBrightnessController").methodFinder().filterByName("checkToScreenOff")
            .first()
            .createHook {
                returnConstant(null)
            }
        XposedBridge.log("SetoHook：AOD Hook 开始(共四段 第三段)")
        loadClass("com.miui.aod.doze.MiuiDozeScreenBrightnessController").methodFinder().filterByName("lambda\$checkToScreenOff\$0")
            .first()
            .createHook {
                returnConstant(null)
            }
        XposedBridge.log("SetoHook：AOD Hook 开始(共四段 第四段)")
    }
}

