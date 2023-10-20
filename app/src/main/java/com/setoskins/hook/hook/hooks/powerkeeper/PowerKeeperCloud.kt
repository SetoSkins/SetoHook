package com.setoskins.hook.hook.hooks.powerkeeper

import android.util.Log
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge

object PowerKeeperCloud : BaseHook() {
    override fun init() {
        loadClass("com.miui.powerkeeper.cloudcontrol.LocalUpdateUtils").methodFinder().filterByName("startCloudSyncData").first()
            .createHook {
                returnConstant(null)
            }

        loadClass("com.miui.powerkeeper.utils.NetUtils").methodFinder().filterByName("isWifiConnected").first()
            .createHook {
                returnConstant(false)
            }

    }
}