package com.setoskins.hook.hook.hooks.powerkeeper

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object ScreenClearApp : BaseHook() {
    override fun init() {
        loadClass("com.miui.powerkeeper.statemachine.PowerStateMachine").methodFinder().filterByName("clearAppWhenScreenOffTimeOut").first()
            .createHook {
                returnConstant(null)
            }
        loadClass("com.miui.powerkeeper.statemachine.PowerStateMachine").methodFinder().filterByName("clearAppWhenScreenOffTimeOutInNight").first()
            .createHook {
                returnConstant(null)
            }
        loadClass("com.miui.powerkeeper.statemachine.SleepModeControllerNew").methodFinder().filterByName("clearApp").first()
            .createHook {
                returnConstant(null)
            }
        loadClass("com.miui.powerkeeper.statemachine.DynamicTurboPowerHandler").methodFinder().filterByName("clearApp").first()
            .createHook {
                returnConstant(null)
            }

    }
}
