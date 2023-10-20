package com.setoskins.hook.hook.hooks.settings

import com.github.kyuubiran.ezxhelper.ClassUtils
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.SettingsFeaturesCls
import com.setoskins.hook.hook.hooks.BaseHook
import com.setoskins.hook.utils.Build.IS_INTERNATIONAL_BUILD
import de.robv.android.xposed.XC_MethodReplacement.returnConstant
import de.robv.android.xposed.XposedBridge


object NoveltyHaptic : BaseHook() {
    override fun init() {
        XposedBridge.log("SetoHook：新版震动Hook 开始") // 添加Xposed的日志输出
        ClassUtils.loadClass("com.android.settings.utils.SettingsFeatures").methodFinder().filterByName("isNoveltyHaptic").first()
                   .createHook {
                        returnConstant(true)
                    }
        XposedBridge.log("SetoHook：新版震动Hook 结束") // 添加Xposed的日志输出
            }
        }
