package com.setoskins.hook.hook.hooks.powerkeeper

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge

object BatteryOptimization : BaseHook() {
    override fun init() {
        loadClass("com.miui.powerkeeper.statemachine.ForceDozeController").methodFinder().filterByName("restoreWhiteListAppsIfQuitForceIdle").first()
            .createHook {
                returnConstant(null)
            }
        XposedBridge.log("SetoHook：电池优化 完成")
            }
        }
