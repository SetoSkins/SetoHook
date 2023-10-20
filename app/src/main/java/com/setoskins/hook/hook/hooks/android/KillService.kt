package com.setoskins.hook.hook.hooks.android

import android.app.job.JobParameters
import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder.`-Static`.methodFinder
import com.setoskins.hook.hook.hooks.BaseHook
import de.robv.android.xposed.XposedBridge

object KillService : BaseHook() {
    override fun init() {

        loadClass("miui.android.animation.Folme").methodFinder().filterByName("doClean").first().createHook {
            before { param ->
                param.result = null
            }
        }

        loadClass("com.android.server.am.PeriodicCleanerService\$MyHandler").methodFinder().filterByName("handleMessage").first().createHook {
            before { param ->
                param.result = null
            }
        }

        loadClass("com.android.server.am.PeriodicCleanerService\$PeriodicShellCmd").methodFinder().filterByName("runClean").first().createHook {
            before { param ->
                param.result = null
            }
        }

        loadClass("com.android.server.am.ProcessKillerIdler").methodFinder().filterByName("onStartJob").filterByParamTypes(
            JobParameters::class.java).first().createHook {
            before { param ->
                param.result = false
            }
        }



        loadClass("com.android.server.am.MiuiMemoryService\$MiuiMemServiceThread").methodFinder().filterByName("run").first().createHook {
            before { param ->
                param.result = null
            }
        }

        loadClass("com.android.server.am.MiuiMemoryService\$ConnectionHandler").methodFinder().filterByName("run").first().createHook {
            before { param ->
                param.result = null
            }
        }

        loadClass("com.android.server.am.MiuiMemReclaimer\$CompactorHandler").methodFinder().filterByName("handleMessage").first().createHook {
            before { param ->
                param.result = null
            }
        }

    }
}
