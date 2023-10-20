package com.setoskins.hook.hook.hooks.securitycenter

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object Dfps : BaseHook() {
    override fun init() {
        val classIMethodMExists = try {
            // 尝试获取类 com.miui.misound.t.i 中的方法 m
            loadClass("s7.x").methodFinder().filterByName("u").first()
            true
        } catch (e: Exception) {
            false
        }

        if (!classIMethodMExists) {
            loadClass("p7.a0").methodFinder().filterByName("u").first()
                .createHook {
                    returnConstant(true)
                }
        } else {
            loadClass("s7.x").methodFinder().filterByName("u").first()
                .createHook {
                    returnConstant(true)

                }
        }
    }
}

