package com.setoskins.hook.activity.pages

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.view.SpinnerV
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import com.github.kyuubiran.ezxhelper.misc.Utils
import com.setoskins.hook.R
import com.setoskins.hook.activity.MainActivity

@BMPage("PowerkeeperPage", "电量与性能", hideMenu = false)
class PowerkeeperPage : BasePage() {
    override fun onCreate() {
          
        TitleText(textId = R.string.powerkeeper)
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.Background_management,
                onClickListener = { showFragment("Background_management") })
        )

Line()

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Test
            ), SwitchV("Test")
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.Test_tips,
                onClickListener = {
                    try {
                        val command = "su -c 'am start -n com.miui.powerkeeper/com.miui.powerkeeper.ui.ThermalConfigActivity'"
                        val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                        process.waitFor()


                    } catch (e: Exception) {
                        Toast.makeText(activity, "电量与性能都被你干完了啊", Toast.LENGTH_LONG).show()
                    }
                }
            )
        )
        Line()
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.PowerKeeperCloud
            ), SwitchV("PowerKeeperCloud")
        )

        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.PowerKeeperCloudview,
                onClickListener = {
                    try {
                        val command = "su -c 'am start -n com.miui.powerkeeper/.ui.CloudInfoActivity --es \"caller\" \"contacts\"'"
                        val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                        process.waitFor()
                    } catch (e: Exception) {
                        Toast.makeText(activity, "电量与性能都被你干完了啊", Toast.LENGTH_LONG).show()
                    }
                }
            )
        )

        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.powerkeeperhide,
                onClickListener = {
                    try {
                        val command = "su -c 'am start -n com.miui.powerkeeper/com.miui.powerkeeper.ui.powertools.PowerToolsActivity'"
                        val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                        process.waitFor()


                    } catch (e: Exception) {
                        Toast.makeText(activity, "电量与性能都被你干完了啊", Toast.LENGTH_LONG).show()
                    }
                }
            )
        )

    }

}