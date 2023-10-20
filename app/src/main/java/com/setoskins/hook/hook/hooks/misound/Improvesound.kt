package com.setoskins.hook.hook.hooks.misound

import android.util.Log
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge

object Improvesound : BaseHook() {
    override fun init() {
        val classIMethodCExists = try {
            // 尝试获取类 com.miui.misound.t.i 中的方法 c
            loadClass("com.miui.misound.t.i").methodFinder().filterByName("c").first()
            true
        } catch (e: Exception) {
            false
        }

        if (classIMethodCExists) {

            loadClass("com.miui.misound.t.i").methodFinder().filterByName("c").first()
                .createHook {
                    returnConstant(true)
                }
                    loadClass("com.miui.misound.t.i").methodFinder().filterByName("e").first()
                        .createHook {
                            returnConstant(true)
                        }
                            loadClass("com.miui.misound.t.i").methodFinder().filterByName("f").first()
                                .createHook {
                                    returnConstant(true)
                                }
                                    loadClass("com.miui.misound.t.i").methodFinder().filterByName("j")
                                        .first()
                                        .createHook {
                                            returnConstant(true)
                                        }
        } else {

            loadClass("com.miui.misound.t.j").methodFinder().filterByName("c").first()
                .createHook {
                    returnConstant(true)
                }
                    loadClass("com.miui.misound.t.j").methodFinder().filterByName("e").first()
                        .createHook {
                            returnConstant(true)
                        }
                            loadClass("com.miui.misound.t.j").methodFinder().filterByName("f").first()
                                .createHook {
                                    returnConstant(true)
                                }
                                    loadClass("com.miui.misound.t.j").methodFinder().filterByName("j")
                                        .first()
                                        .createHook {
                                            returnConstant(true)
                                        }
        }
    }
}


