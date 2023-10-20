package com.setoskins.hook.activity.pages

import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.activity.view.SpinnerV
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import com.setoskins.hook.R


@BMPage("Background_management", "后台管理", hideMenu = false)
class BmPage : BasePage() {
    override fun onCreate() {
          
        TitleText(textId = R.string.powerkeeper)
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Make_millet_stronger
            ), SwitchV("Makemilletstronger")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.RestrictAlarm,
                tipsId = R.string.Turn_off_cron_tasks,
            ), SwitchV("RestrictAlarm")
        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.AutoKillAPP,
            ), SwitchV("AutoKillAPP")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.ScreenClearApp,
                tipsId = R.string.ScreenClearApp_tips,
            ), SwitchV("ScreenClearApp")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.KillAdj,
                tipsId = R.string.ScreenClearApp_tips,
            ), SwitchV("OOM")
        )
        TextSummaryWithSpinner(
            TextSummaryV(
                textId = R.string.OffCache,
                tips = getString(R.string.Close_option_to_reboot),
            ),
            SpinnerV(MIUIActivity.safeSP.getString("OffCache", "默认")) {
                add("开启") {
                    MIUIActivity.safeSP.putAny("OffCache", "开启")
                    val command = "su -c 'device_config put activity_manager max_cached_processes 2147483647'"
                    val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                    process.waitFor()
                }
                add("关闭") {
                    MIUIActivity.safeSP.putAny("OffCache", "关闭")
                    val command = "su -c 'device_config set_sync_disabled_for_tests none'"
                    val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                    process.waitFor()
                }
            })
        TextSummaryWithSpinner(
            TextSummaryV(
                textId = R.string.ProcessRestrictions,
                tips = getString(R.string.Close_option_to_reboot),
            ),
            SpinnerV(MIUIActivity.safeSP.getString("ProcessRestrictions", "默认")) {
                add("开启") {
                    MIUIActivity.safeSP.putAny("ProcessRestrictions", "开启")
                    val command = "su -c 'device_config set_sync_disabled_for_tests persistent'"
                    val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                    process.waitFor()
                    val command2 = "su -c 'device_config put activity_manager max_phantom_processes 2147483647'"
                    val process2 = Runtime.getRuntime().exec(arrayOf("sh", "-c", command2))
                    process2.waitFor()
                }
                add("关闭") {
                    MIUIActivity.safeSP.putAny("ProcessRestrictions", "关闭")
                    val command = "su -c 'device_config set_sync_disabled_for_tests none'"
                    val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                    process.waitFor()
                }
            })
        TitleText(textId = R.string.system)
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.PerformIdleMaintenance,
            ), SwitchV("PerformIdleMaintenance")
        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.HandleAutoLockOff,
            ), SwitchV("HandleAutoLockOff")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.HandleThermalKillProc,
            ), SwitchV("HandleThermalKillProc")
        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.BoostCameraIfNeeded,
            ), SwitchV("BoostCameraIfNeeded")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.CheckBackgroundProcCompact,
            ), SwitchV("CheckBackgroundProcCompact")
        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.GameMemory,
            ), SwitchV("GameMemory")
        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.KillAdj,
            ), SwitchV("KillAdj")
        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.KillService,
            ), SwitchV("KillService")
        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.ShellKillAll,
            ), SwitchV("ShellKillAll")
        )



        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Disablecachingapps,
            ), SwitchV("Disablecachingapps")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.KillProcess,
            ), SwitchV("KillProcess")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.IsInVisibleRange,
            ), SwitchV("IsInVisibleRange")
        )

    }

}