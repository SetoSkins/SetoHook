package com.setoskins.hook.activity.pages

import android.content.Intent
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import android.content.Context
import android.view.View
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import com.setoskins.hook.R

@BMPage("SecuritycenterPage", "手机管家", hideMenu = false)
class SecuritycenterPage : BasePage() {
    override fun onCreate() {
          
       TitleText(textId = R.string.securitycenter)
//        TextSummaryWithSwitch(
//            TextSummaryV(
//                textId = R.string.ManagementMeasures,
//            ), SwitchV("ManagementMeasures")
//        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Dfps,
            ), SwitchV("Dfps")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Ndds,
                tipsId = R.string.Ndds_tips
            ), SwitchV("Ndds")
        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Dsda,
                tipsId = R.string.Dsda_tips
            ), SwitchV("Dsda")
        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Memc,
                tipsId = R.string.Memc_tips
            ), SwitchV("Memc")
        )

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.balanced_performance_mode,
                tipsId = R.string.balanced_performance_mode_tips
            ), SwitchV("BalanceMode")
        )


        TitleText(textId = R.string.Barrage_notification)
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Barrage_notification2,
                tipsId = R.string.Close_option_to_reboot,
            ), SwitchV("Barragenotification2")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Barrage_notification3,
            ), SwitchV("Barragenotification")
        )
    }

}