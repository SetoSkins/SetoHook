package com.setoskins.hook.hook.hooks.settings

import com.github.kyuubiran.ezxhelper.ClassUtils
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.SettingsFeaturesCls
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge


object OldNoveltyHaptic : BaseHook() {
    override fun init(){
        XposedBridge.log("SetoHook：旧版震动Hook 开始(第一段)") // 添加Xposed的日志输出
        ClassUtils.loadClass("com.android.settings.utils.SettingsFeatures").methodFinder().filterByName("isNoveltyHaptic").first()
                   .createHook {
                        returnConstant(false)
                    }


        SettingsFeaturesCls.methodFinder()
            .filterByName("isSupportSettingsHaptic")
            .first().createHook {
                returnConstant(false)
            }
        XposedBridge.log("SetoHook：旧版震动Hook 结束") // 添加Xposed的日志输出
            }
        }
