package com.setoskins.hook.hook.hooks.settings

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHooks
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object GPSLocation : BaseHook() {
    override fun init(){
        loadClass("com.android.settings.location.XiaomiHpLocationController")
            .methodFinder().filter {
                name in setOf("hasXiaomiHpFeature", "isZh")
            }.toList().createHooks {
                returnConstant(true)
            }
    }
}