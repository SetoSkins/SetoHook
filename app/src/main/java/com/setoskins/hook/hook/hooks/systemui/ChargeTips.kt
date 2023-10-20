package com.setoskins.hook.hook.hooks.systemui

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object ChargeTips : BaseHook() {
    override fun init() {
        loadClass("com.android.keyguard.charge.ChargeUtils").methodFinder().filterByName("getChargingHintText").first()
            .createHook {
                returnConstant(null)
            }
    }
}

