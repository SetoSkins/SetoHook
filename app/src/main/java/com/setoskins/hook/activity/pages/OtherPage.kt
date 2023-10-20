package com.setoskins.hook.activity.pages

import android.content.Intent
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import android.content.Context
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import com.setoskins.hook.R

@BMPage("OtherPage", "其他", hideMenu = false)
class OtherPage : BasePage() {
    override fun onCreate() {

//        TextSummaryWithSwitch(
//            TextSummaryV(
//                textId = R.string.ThemeHook,
//            ), SwitchV("ThemeHook")
//        )
          
        TitleText(textId = R.string.other)


        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.DarkModeForAllApps,
                tipsId = R.string.DarkModeForAllApps_tips
            ), SwitchV("DarkModeForAllApps")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.SaveAsPng,
                tipsId = R.string.SaveAsPng_tips
            ), SwitchV("SaveAsPng")
        )


        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.AodSummary,
            ), SwitchV("AodSummary")
        )
        Line()
        TitleText(textId = R.string.SystemUi)

        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.ControlCenterStyle,
            ), SwitchV("ControlCenterStyle")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.ChargeTips,
            ), SwitchV("ChargeTips")
        )

    }

}