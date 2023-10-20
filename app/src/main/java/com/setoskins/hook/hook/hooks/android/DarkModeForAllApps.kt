package com.setoskins.hook.hook.hooks.android

import android.content.pm.ApplicationInfo
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.ClassUtils.setStaticObject
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHooks
import com.github.kyuubiran.ezxhelper.ObjectUtils.invokeMethodBestMatch
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.MiuiBuildCls
import com.setoskins.hook.hook.hooks.BaseHook
import com.setoskins.hook.utils.Build.IS_INTERNATIONAL_BUILD


object DarkModeForAllApps : BaseHook() {
    override fun init() {
        if (IS_INTERNATIONAL_BUILD) return
        val clazzForceDarkAppListManager =
            loadClass("com.android.server.ForceDarkAppListManager")
        clazzForceDarkAppListManager.methodFinder().filterByName("getDarkModeAppList").toList()
            .createHooks {
                before {
                    setStaticObject(MiuiBuildCls, "IS_INTERNATIONAL_BUILD", true)
                }
                after {
                    setStaticObject(
                        MiuiBuildCls,
                        "IS_INTERNATIONAL_BUILD",
                        IS_INTERNATIONAL_BUILD
                    )
                }
            }
        clazzForceDarkAppListManager.methodFinder().filterByName("shouldShowInSettings").toList()
            .createHooks {
                before { param ->
                    val info = param.args[0] as ApplicationInfo?
                    param.result =
                        !(info == null || (invokeMethodBestMatch(
                            info,
                            "isSystemApp"
                        ) as Boolean) || info.uid < 10000)
                }
            }
    }
}
