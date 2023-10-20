package com.setoskins.hook.hook.hooks.android

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge

object KillAdj : BaseHook() {
    override fun init() {


                loadClass("miui.process.ProcessManager").methodFinder().first {
                    name == "kill"
                }.createHook {
                    before {
                        it.result = false
                    }
                }

                loadClass("com.android.server.am.ActivityManagerService").methodFinder()
                    .filterByName("checkExcessivePowerUsage").first().createHook {
                        before { param ->
                            param.result = null
                        }
                    }
        loadClass("com.android.server.am.ActivityManagerService").methodFinder().filterByName("killProcessesBelowAdj").filterByParamTypes(Int::class.java, String::class.java)
            .first().createHook {
                before {
                    it.result = true
                }
                        
                    }
                            loadClass("com.android.server.am.PhantomProcessList").methodFinder()
            .filterByName("trimPhantomProcessesIfNecessary").first().createHook {
                before { param ->
                    param.result = null
                }
            }
            }
    }
