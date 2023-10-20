package com.setoskins.hook.hook.hooks.misound

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object Harman : BaseHook() {
    override fun init() {
        val classIMethodMExists = try {
            // 尝试获取类 com.miui.misound.t.i 中的方法 m
            loadClass("com.miui.misound.t.i").methodFinder().filterByName("m").first()
            true
        } catch (e: Exception) {
            false
        }

        if (!classIMethodMExists) {
            loadClass("com.miui.misound.t.j").methodFinder().filterByName("n").first()
                .createHook {
                    returnConstant(true)
                }
        } else {
            loadClass("com.miui.misound.t.i").methodFinder().filterByName("m").first()
                .createHook {
                    returnConstant(true)

                        }
                }
        }
    }

