package com.setoskins.hook.activity.pages

import android.content.ComponentName
import android.content.Intent
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.MIUIActivity
import android.content.Context
import android.widget.Toast
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import com.setoskins.hook.R

@BMPage("SoundPage", "音质音效", hideMenu = false)
class SoundPage : BasePage() {
    override fun onCreate() {
          
        TitleText(textId = R.string.misound_tips)
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Improve_sound_quality
            ), SwitchV("Improvesound")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.increase_sampling_rate
            ), SwitchV("Increasesamplingrate")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Harman
            ), SwitchV("Harman")
        )
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Turn_on_virtual_surround,
                tipsId = R.string.Surround_tips
            ), SwitchV("Surround")
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.opensound,
                tipsId = R.string.restart_scope_tips,
                onClickListener = {
                    try {
                        val intent = Intent()
                        val comp = ComponentName(
                            "com.miui.misound",
                            "com.miui.misound.HeadsetSettingsActivity"
                        )
                        intent.component = comp
                        activity.startActivity(intent)
                    } catch (e: Exception) {
                        Toast.makeText(activity, "你的音质音效呢？", Toast.LENGTH_LONG).show()
                    }
                }
            )
        )
        TitleText(textId = R.string.misound_tips2)
    }

}