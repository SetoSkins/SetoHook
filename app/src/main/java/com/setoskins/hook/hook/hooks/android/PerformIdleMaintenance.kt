package com.setoskins.hook.hook.hooks.android

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object PerformIdleMaintenance : BaseHook() {
    override fun init() {
        loadClass("com.android.server.am.ActivityManagerService").methodFinder().filterByName("performIdleMaintenance").first().createHook {
                before { param ->
                    param.result = null
                }
        loadClass("com.android.server.wm.RecentTasks").methodFinder().filterByName("trimInactiveRecentTasks").first().createHook {
                before { param ->
                    param.result = null
                }
    }
}
    }
}
