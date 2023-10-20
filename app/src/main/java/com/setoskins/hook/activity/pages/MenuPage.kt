package com.setoskins.hook.activity.pages

import android.content.ComponentName
import android.content.pm.PackageManager
import android.widget.Toast
import cn.fkj233.ui.activity.data.BasePage
import android.app.Activity
import android.content.Context
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.core.app.ActivityCompat.finishAffinity
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.activity.annotation.BMMenuPage
import cn.fkj233.ui.activity.view.SpinnerV
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import cn.fkj233.ui.activity.view.TextV
import cn.fkj233.ui.dialog.MIUIDialog
import com.setoskins.hook.hook.PACKAGE_NAME_HOOKED
import com.setoskins.hook.utils.Terminal
import com.setoskins.hook.BuildConfig
import com.setoskins.hook.R
import com.setoskins.hook.activity.MainActivity
import com.setoskins.hook.utils.yife.XSharedPreferences.prefFileName
import com.setoskins.hook.utils.key.BackupUtils.backup
import com.setoskins.hook.utils.key.BackupUtils.recovery
import kotlin.random.Random
import kotlin.system.exitProcess

@BMMenuPage("Menu")
class MenuPage : BasePage() {
    override fun onCreate() {
          
        TitleText(textId = R.string.reboot)


        TextSummaryWithArrow(TextSummaryV(
            textId = R.string.reboot_system
        ) {
            MIUIDialog(activity) {
                setTitle(R.string.warning)
                setMessage(R.string.reboot_tips)
                setLButton(R.string.cancel) {
                    dismiss()
                }
                setRButton(R.string.done) {
                    Terminal.exec("/system/bin/sync;/system/bin/svc power reboot || reboot")
                }
            }.show()

        })
        TextSummaryWithArrow(TextSummaryV(
            textId = R.string.ReboootSystemUi
        ) {
            MIUIDialog(activity) {
                setTitle(R.string.warning)
                setMessage(R.string.restart_all_scope_tips)
                setLButton(R.string.cancel) {
                    dismiss()
                }
                setRButton(R.string.done) {
                    PACKAGE_NAME_HOOKED.forEach { packageName ->
                        Terminal.exec("killall com.android.systemui")
                    }
                    Toast.makeText(
                        activity, getString(R.string.reboot_complete), Toast.LENGTH_SHORT
                    ).show()
                    dismiss()
                }
            }.show()
        })
        TextSummaryWithArrow(TextSummaryV(
            textId = R.string.restart_scope
        ) {
            MIUIDialog(activity) {
                setTitle(R.string.warning)
                setMessage(R.string.restart_all_scope_tips)
                setLButton(R.string.cancel) {
                    dismiss()
                }
                setRButton(R.string.done) {
                    val command2 = "su -c 'pm clear --cache-only com.miui.aod'"
                    val process2 = Runtime.getRuntime().exec(arrayOf("sh", "-c", command2))
                    process2.waitFor()
                    val command = "su -c 'pm clear --cache-only com.miui.securitymanager'"
                    val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                    process.waitFor()
                    val command3 = "su -c 'pm clear --cache-only com.android.settings'"
                    val process3 = Runtime.getRuntime().exec(arrayOf("sh", "-c", command3))
                    process3.waitFor()
                    val command4 = "su -c 'pm clear --cache-only com.miui.powerkeeper'"
                    val process4 = Runtime.getRuntime().exec(arrayOf("sh", "-c", command4))
                    process4.waitFor()
                    val command5 = "su -c 'pm clear --cache-only com.xiaomi.misettings'"
                    val process5 = Runtime.getRuntime().exec(arrayOf("sh", "-c", command5))
                    process5.waitFor()
                    val command6 = "su -c 'pm clear --cache-only com.android.camera'"
                    val process6 = Runtime.getRuntime().exec(arrayOf("sh", "-c", command6))
                    process6.waitFor()
                    PACKAGE_NAME_HOOKED.forEach { packageName ->
                        if (packageName != "android" && packageName != "com.android.systemui") {
                            Terminal.exec("killall $packageName")
                        }
                    }
                    Toast.makeText(
                        activity, getString(R.string.reboot_complete), Toast.LENGTH_SHORT
                    ).show()
                    dismiss()
                }
            }.show()
        })

        Line()


        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.backup, onClickListener = {
                    backup(
                        activity,
                        activity.createDeviceProtectedStorageContext()
                            .getSharedPreferences(prefFileName, Context.MODE_WORLD_READABLE)
                    )
                })
        )

        TextSummaryWithArrow(TextSummaryV(textId = R.string.recovery, onClickListener = {
            recovery(
                    activity,
                    activity.createDeviceProtectedStorageContext()
                        .getSharedPreferences(prefFileName, Context.MODE_WORLD_READABLE)

            )

        }
        )
        )

        TextSummaryWithArrow(TextSummaryV(textId = R.string.ResetModule, onClickListener = {
            MIUIDialog(activity) {
                setTitle(R.string.ResetModuleDialog)
                setMessage(R.string.ResetModuleDialogTips)
                setRButton(R.string.done) {
                    activity.getSharedPreferences(prefFileName, Activity.MODE_WORLD_READABLE)
                        .edit().clear().apply()
                    makeText(
                        activity,
                        activity.getString(R.string.ResetSuccess),
                        LENGTH_SHORT

                    ).show()

                }
                setLButton(R.string.cancel)
                finally { dismiss() }

            }.show()

      }))
//        TextSummaryWithSpinner(
//            TextSummaryV(
//                textId = R.string.SafeMode,
//            ),
//            SpinnerV(MIUIActivity.safeSP.getString("SafeMode", "关闭")) {
//                add("开启") {
//                    MIUIActivity.safeSP.putAny("SafeMode", "开启")
//                    MIUIDialog(activity) {
//                        setTitle(R.string.tips)
//                        setMessage("此选项用于测试或调试开关，打开后下下次重启会禁用Lsposed，如果下次开机正常请务必手动关闭选项。")
//                        setRButton(R.string.done) {
//                            val command = "su -c 'echo \"#!/system/bin/sh\\nwait_until_login() {\\nwhile [ ! -d \\\"/sdcard/Android\\\" ]; do\\nsleep 1\\ndone\\n}\\nwait_until_login\\nchmod 777 /data/adb/service.d/\\ntouch /data/adb/modules/zygisk_lsposed/disable\\nrm -rf /data/adb/service.d/SafeMode.sh\" > /data/adb/service.d/SafeMode.sh'"
//                            val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
//                            process.waitFor()
//                            dismiss()
//                        }
//                    }.show()
//                    }
//                    add("关闭") {
//                        MIUIActivity.safeSP.putAny("SafeMode", "关闭")
//                             val command = "su -c 'rm -rf /data/adb/modules/zygisk_lsposed/disable'"
//                            val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
//                            process.waitFor()
//
//                }})
        Line()
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.HideLauncherIcon,
            ),
            SwitchV("hLauncherIcon", onClickListener = {
                activity.packageManager.setComponentEnabledSetting(
                    ComponentName(activity, "${BuildConfig.APPLICATION_ID}.launcher"),
                    if (it) {
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED
                    } else {
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                    },
                    PackageManager.DONT_KILL_APP
                )
            })
        )

        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.about_module,
                tips = getString(R.string.about_module_summary),
                onClickListener = { showFragment("about_module") })
        )

    }
}