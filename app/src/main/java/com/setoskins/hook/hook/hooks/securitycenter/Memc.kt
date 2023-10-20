package com.setoskins.hook.hook.hooks.securitycenter

import android.content.pm.ApplicationInfo
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHooks
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import com.setoskins.hook.utils.api.findField
import com.setoskins.hook.utils.api.setObjectField
import de.robv.android.xposed.XposedBridge

object Memc : BaseHook() {
    override fun init() {
        loadClass("b8.q").methodFinder()
            .filterByName("u")
            .first().createHook {
                returnConstant(true)
            }

    }
}