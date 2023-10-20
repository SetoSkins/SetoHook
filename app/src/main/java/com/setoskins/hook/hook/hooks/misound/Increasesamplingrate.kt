package com.setoskins.hook.hook.hooks.misound

import android.content.Context
import android.media.AudioTrack
import com.github.kyuubiran.ezxhelper.ClassUtils
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import com.setoskins.hook.utils.api.setObjectField
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage
import de.robv.android.xposed.XposedBridge

object Increasesamplingrate : BaseHook() {
    override fun init() {
        XposedBridge.log("SetoHook：音频采样率Hook (共七段 第一段)") // 添加Xposed的日志输出
        loadClass("com.miui.misound.EqualizerView").methodFinder()

            .first().createHook {
                before {
                    it.thisObject.setObjectField("l", "0x2ee00")
                }
            }
        XposedBridge.log("SetoHook：音频采样率Hook (共七段 第二段)") // 添加Xposed的日志输出
        loadClass("com.miui.misound.mihearingassist.h").methodFinder()
            .first().createHook {
                before {
                    it.thisObject.setObjectField("a", "0x2ee00")
                }
            }
        XposedBridge.log("SetoHook：音频采样率Hook (共七段 第三段)") // 添加Xposed的日志输出
        loadClass("com.miui.misound.mihearingassist.h").methodFinder()
            .filterByName("b")
            .first().createHook {
                before {
                    it.args[1] = "0x2ee00"
                }
            }

        XposedBridge.log("SetoHook：音频采样率Hook (共七段 第四段)") // 添加Xposed的日志输出
        loadClass("com.miui.misound.soundid.controller.AudioTrackController").methodFinder()
            .filterByParamCount(2)
            .first().createHook {
                before {
                    it.args[0] = "0x2ee00"
                }
            }
        XposedBridge.log("SetoHook：音频采样率Hook (共七段 第五段)") // 添加Xposed的日志输出
        loadClass("com.miui.misound.soundid.controller.AudioTrackController").methodFinder()

            .filterByParamCount(3)
            .first().createHook {
                before {
                    it.args[0] = "0x2ee00"
                }
            }
        XposedBridge.log("SetoHook：音频采样率Hook (共七段 第六段)") // 添加Xposed的日志输出
        loadClass("miuix.media.Mp3Encoder").methodFinder()

            .first().createHook {
                before {
                    it.thisObject.setObjectField("DEFAULT_SAMPLE_RATE", "0x2ee00")
                }
            }
        XposedBridge.log("SetoHook：音频采样率Hook (共七段 第七段)") // 添加Xposed的日志输出
        loadClass("com.miui.misound.mihearingassist.h").methodFinder()
            .filterByName("b")
            .first().createHook {
                before {
                    it.args[6] = "0x2ee00"
                }
            }
        XposedBridge.log("SetoHook：音频采样率Hook 已完成") // 添加Xposed的日志输出
    }
}
