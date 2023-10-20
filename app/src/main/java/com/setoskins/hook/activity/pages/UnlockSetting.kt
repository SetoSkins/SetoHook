package com.setoskins.hook.activity.pages

import android.content.ComponentName
import android.content.Intent
import android.widget.Toast
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.activity.MIUIActivity.Companion.safeSP
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.view.SpinnerV
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import com.setoskins.hook.R

@BMPage("UnlockSetting", "设置解锁", hideMenu = false)
class UnlockSetting : BasePage() {
    override fun onCreate() {
          
        TitleText(textId = R.string.UnlockSetting)
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Old_NoveltyHaptic,
                tipsId = R.string.conflict,
            ), SwitchV("OldNoveltyHaptic")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.NoveltyHaptic,
                        tipsId = R.string.NoveltyHaptic_tips,
            ), SwitchV("NoveltyHaptic")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.high_precision_GPS
            ), SwitchV("GPSLocation")
        )

Line()
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.speed_mode_enable,
                onClickListener = {

                    val command = "su -c 'settings put Secure speed_mode_enable 1'"
                    val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                    process.waitFor()
                    Toast.makeText(activity, "开启成功", Toast.LENGTH_LONG).show()
                }
            )
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.performance,
                onClickListener = {
                    try {
                        val intent = Intent()
                        val comp = ComponentName(
                            "com.qualcomm.qti.performancemode",
                            "com.qualcomm.qti.performancemode.PerformanceModeActivity"
                        )
                        intent.component = comp
                        activity.startActivity(intent)
                    } catch (e: Exception) {
                        Toast.makeText(activity, "MTK和老机型就别来沾边了", Toast.LENGTH_LONG).show()
                    }
                }
            )
        )
    }


}