package com.setoskins.hook.hook.hooks.android

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object NStartPressureMonitor : BaseHook() {
    override fun init() {
        loadClass("com.android.server.am.SystemPressureController").methodFinder().filterByName("nStartPressureMonitor").first().createHook {
                before { param ->
                    param.result = null
                }

    }
}
}
