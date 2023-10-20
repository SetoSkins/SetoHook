package com.setoskins.hook.hook.hooks.systemui

import android.graphics.Color
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClassOrNull
import com.setoskins.hook.hook.utils.key.XSPUtils.getString

object MonetSelection : BaseHook() {
    override fun init() {
        loadClassOrNull("com.android.systemui.theme.ThemeOverlayController")!!.methodFinder()
            .filterByName("getOverlay")
            .filterByParamCount(3)
            .first {
                parameterTypes[0] == Int::class.java && parameterTypes[1] == Int::class.java
            }.createHook {
                before { param ->
                    //                    Log.i("Monet Key: " + param.args[1] as Int)
                    when (param.args[1] as Int) {
                        1 -> {
                            param.args[0] =
                                Color.parseColor(getString("your_theme_accent_color", "#0d84ff"))
                        }
                        // else 0
                        0 -> {
                            param.args[0] =
                                Color.parseColor(getString("your_theme_neutral_color", "#0d84ff"))

                        }
                    }

                }
            }
    }
}