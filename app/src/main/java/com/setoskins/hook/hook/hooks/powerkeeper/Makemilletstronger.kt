package com.setoskins.hook.hook.hooks.powerkeeper

import android.util.Log
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers

object Makemilletstronger : BaseHook() {
    override fun init() {
                    loadClass("com.miui.powerkeeper.controller.FrozenAppController\$FrozenUtil").methodFinder().filterByName("isExectingService").first().createHook {
                        returnConstant(false)
                    }
                    loadClass("com.miui.powerkeeper.controller.FrozenAppController\$FrozenUtil").methodFinder().filterByName("isReceivingBroadcast").first().createHook {
                        returnConstant(false)
                    }
                loadClass("com.miui.powerkeeper.controller.FrozenAppController\$FrozenUtil").methodFinder().filterByName("isHasRunningStateProcess").first().createHook {
                    returnConstant(false)
                }
                    loadClass("com.miui.powerkeeper.controller.FrozenAppController\$FrozenUtil").methodFinder().filterByName("isHasProcessOOMTooLow").first().createHook {
                        returnConstant(false)
                    }
                    loadClass("com.miui.powerkeeper.controller.FrozenAppController").methodFinder().filterByName("isHasNotification").first().createHook {
                        returnConstant(false)
                    }

                    loadClass("com.miui.powerkeeper.controller.FrozenAppController\$AppStateFrozenControl").methodFinder().filterByName("isAllowFrozenNow").first().createHook {
                        returnConstant(true)
                    }
            }
        }

