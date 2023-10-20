package com.setoskins.hook.hook.hooks.powerkeeper

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object AutoKillAPP : BaseHook() {
    override fun init() {
        loadClass("com.miui.powerkeeper.powerchecker.PowerCheckerController").methodFinder().filterByName("clearApp").first()
            .createHook {
                returnConstant(null)
            }
        loadClass("com.miui.powerkeeper.powerchecker.PowerCheckerController").methodFinder().filterByName("autoKillApp").first()
            .createHook {
                returnConstant(null)
            }
        loadClass("miui.process.ProcessManager").methodFinder().filterByName("kill").first()
            .createHook {
                returnConstant(false)
            }

    }
}
