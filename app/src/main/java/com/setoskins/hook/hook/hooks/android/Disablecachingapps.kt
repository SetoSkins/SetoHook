package com.setoskins.hook.hook.hooks.android

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge

object Disablecachingapps : BaseHook() {
    override fun init() {

        XposedBridge.log("SetoHook：禁止停止后台受限和缓存的应用 内存管理Hook 开始")
        loadClass("com.android.server.am.ProcessList").methodFinder()
            .filterByName("killAppIfBgRestrictedAndCachedIdleLocked").first().createHook {
            before { param ->
                param.result = 0L
            }
                XposedBridge.log("SetoHook：禁止停止后台受限和缓存的应用 内存管理Hook 结束")
        }
    }
}
