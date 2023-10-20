package com.setoskins.hook.hook.hooks.securitycenter

import android.content.Context
import android.widget.Toast
import cn.fkj233.ui.activity.MIUIActivity.Companion.activity
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHooks
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XC_MethodHook

object BalanceMode : BaseHook() {
    override fun init() {
        loadClass("y6.g").methodFinder().filterByName("j").first()
            .createHook {
                returnConstant(true)
            }
    }
}
