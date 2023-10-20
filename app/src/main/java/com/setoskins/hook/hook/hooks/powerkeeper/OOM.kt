package com.setoskins.hook.hook.hooks.powerkeeper

import android.util.Log
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge

object OOM : BaseHook() {
    override fun init() {
        loadClass("com.miui.powerkeeper.controller.FrozenAppController\$FrozenUtil").methodFinder().filterByName("isHasProcessOOMTooLow").first()
            .createHook {
                returnConstant(false)
            }

        loadClass("com.miui.powerkeeper.controller.FrozenAppController\$FrozenUtil").methodFinder().filterByName("getOomAdjByPid").first()
            .createHook {
                returnConstant(false)
            }
    }
}