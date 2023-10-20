package com.setoskins.hook.hook.hooks

import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.XposedHelpers.ClassNotFoundError
import de.robv.android.xposed.XposedHelpers.findClass


abstract class BaseHook {
    var isInit: Boolean = false
    abstract fun init()

}
