package com.setoskins.hook.hook.hooks.android

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge

object IsInVisibleRange : BaseHook() {
    override fun init() {
        XposedBridge.log("SetoHook：禁用最近任务的非可见范围导致的杀后台 内存管理Hook 开始")
        loadClass("com.android.server.wm.RecentTasks").methodFinder().filterByName("isInVisibleRange")
            .first().createHook {
                before { param ->
                    param.args[2] = 0;
                }
                XposedBridge.log("SetoHook：禁用最近任务的非可见范围导致的杀后台 内存管理Hook 结束")
            }
    }
}