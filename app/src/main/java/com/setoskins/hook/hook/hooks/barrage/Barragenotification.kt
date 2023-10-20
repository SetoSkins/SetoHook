package com.setoskins.hook.hook.hooks.barrage

import android.content.ContentResolver
import android.provider.Settings
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHooks
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object Barragenotification : BaseHook() {
    override fun init(){
        loadClass("android.provider.Settings\$Secure").methodFinder().filterByName("getInt")
            .toList().createHooks {
            after { param ->
                if ((param.args[1] as String) == "gb_boosting" && param.result != 1) {
                    Settings.Secure.putInt(param.args[0] as ContentResolver?, "gb_boosting", 1)
                    param.result = 1
                }
            }
        }
    }
}