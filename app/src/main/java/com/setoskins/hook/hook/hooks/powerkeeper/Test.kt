package com.setoskins.hook.hook.hooks.powerkeeper

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object Test : BaseHook() {
    override fun init() {
        loadClass("com.miui.powerkeeper.ui.ThermalConfigActivity$2$1").methodFinder().filterByName("run").first()
            .createHook {
                returnConstant(false)
            }
    }
}
