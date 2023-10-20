package com.setoskins.hook.hook.hooks.android

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge

object KillProcess : BaseHook() {
    override fun init() {
        XposedBridge.log("SetoHook：Process 内存管理Hook 开始")
        loadClass("com.android.server.am.ProcessMemoryCleaner").methodFinder().filterByName("killProcess").first()
            .createHook {
                before { param ->
                    param.result = null
                }
            }
        loadClass("com.android.server.am.ProcessMemoryCleaner\$H").methodFinder().filterByName("handleMessage").first().createHook {
            before { param ->
                param.result = null
            }
        }
    
        XposedBridge.log("SetoHook：Process 内存管理Hook 结束")
    }
}
