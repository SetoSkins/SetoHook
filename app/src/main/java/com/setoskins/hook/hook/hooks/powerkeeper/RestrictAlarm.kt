package com.setoskins.hook.hook.hooks.powerkeeper

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import android.util.Log // 导入 Log 类
import de.robv.android.xposed.XposedBridge

object RestrictAlarm : BaseHook() {
    override fun init() {
        loadClass("com.miui.powerkeeper.controller.AlarmController").methodFinder().filterByName("updateAlarmAlignConfig").first()
            .createHook {
                returnConstant(null)
            }
    }
}