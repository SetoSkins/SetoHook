package com.setoskins.hook.activity.pages

import android.content.Intent
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import android.content.Context
import android.net.Uri
import android.widget.Toast
import cn.fkj233.ui.activity.view.ImageTextV
import cn.fkj233.ui.activity.view.TextSummaryV
import cn.fkj233.ui.dialog.MIUIDialog
import com.setoskins.hook.R
import kotlin.random.Random

@BMPage("thank", "Thank List", hideMenu = true)
class ThankList : BasePage() {
    override fun onCreate() {

          
        TitleText(text = "开源项目")
        TextSummaryWithArrow(
            TextSummaryV(
                text = "BlockMIUI",
                tips = ("@方块君"),
                onClickListener = {
                    activity.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/Block-Network/blockmiui")
                        )
                    )
                }
            )
        )

        TextSummaryWithArrow(
            TextSummaryV(
                text = "StarVoyager",
                tips = ("@hosizoraru"),
                onClickListener = {
                    activity.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/hosizoraru/StarVoyager")
                        )
                    )
                }
            )
        )
        TextSummaryWithArrow(
            TextSummaryV(
                text = "EzXHelper",
                tips = ("@KyuubiRan"),
                onClickListener = {
                    activity.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/KyuubiRan/EzXHelper")
                        )
                    )
                }
            )
        )
        TextSummaryWithArrow(
            TextSummaryV(
                text = "MaxFreeForm",
                tips = ("@YifePlayte"),
                onClickListener = {
                    activity.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/YifePlayte/MaxFreeForm")
                        )
                    )
                }
            )
        )
        TextSummaryWithArrow(
            TextSummaryV(
                text = "MiuiFreeFormX",
                tips = ("@LiuYiGL"),
                onClickListener = {
                    activity.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/Xposed-Modules-Repo/org.liuyi.mifreeformx")
                        )
                    )
                }
            )
        )
        TextSummaryWithArrow(
            TextSummaryV(
                text = "AppRetentionHook",
                tips = ("@HChenX"),
                onClickListener = {
                    activity.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/HChenX/AppRetentionHook")
                        )
                    )
                }
            )
        )
        Line()
        TitleText(text = "个人开发者")
        ImageWithText(
            authorHead = getDrawable(R.drawable.ray),
            authorName = "笨蛋Ray",
            onClickListener = {
                val command = "su -c 'am start -d 'coolmarket://u/2819385' >/dev/null 2>&1'"
                val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                process.waitFor()

            }
            )


        TitleText(text = "排名不分先后")
    }
}