package com.setoskins.hook.hook.hooks.android

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook

object GameMemory : BaseHook() {
    override fun init() {
        loadClass("com.miui.server.migard.memory.GameMemoryCleaner").methodFinder().filterByName("reclaimMemoryForGameIfNeed")
            .first().createHook {
            before { param ->
                param.result = null
            }

        }
    }
}
