package com.setoskins.hook.hook.hooks.misound

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object Surround : BaseHook() {
    override fun init() {
        val classIMethodOExists = try {
            // 尝试获取类 com.miui.misound.t.i 中的方法 o
            loadClass("com.miui.misound.t.i").methodFinder().filterByName("o").first()
            true
        } catch (e: Exception) {
            false
        }

        if (classIMethodOExists) {
            loadClass("com.miui.misound.t.i").methodFinder().filterByName("o").first()
                .createHook {
                    returnConstant(true)
                    loadClass("com.miui.misound.t.i").methodFinder().filterByName("g").first()
                        .createHook {
                            returnConstant(true)
                            loadClass("com.miui.misound.t.i").methodFinder().filterByName("k").first()
                                .createHook {
                                    returnConstant(true)
                                    loadClass("com.miui.misound.t.i").methodFinder().filterByName("l")
                                        .first()
                                        .createHook {
                                            returnConstant(true)
                                            loadClass("com.miui.misound.t.i").methodFinder()
                                                .filterByName("n").first()
                                                .createHook {
                                                    returnConstant(true)
                                                }
                                        }
                                }
                        }
                }
        } else {
            loadClass("com.miui.misound.t.j").methodFinder().filterByName("o").first()
                .createHook {
                    returnConstant(true)
                    loadClass("com.miui.misound.t.j").methodFinder().filterByName("g").first()
                        .createHook {
                            returnConstant(true)
                            loadClass("com.miui.misound.t.j").methodFinder().filterByName("k").first()
                                .createHook {
                                    returnConstant(true)
                                    loadClass("com.miui.misound.t.j").methodFinder().filterByName("l")
                                        .first()
                                        .createHook {
                                            returnConstant(true)
                                            loadClass("com.miui.misound.t.j").methodFinder()
                                                .filterByName("n").first()
                                                .createHook {
                                                    returnConstant(true)
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
