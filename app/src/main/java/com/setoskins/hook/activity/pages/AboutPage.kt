package com.setoskins.hook.activity.pages

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri.parse
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import cn.fkj233.ui.activity.annotation.BMPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.view.TextSummaryV
import cn.fkj233.ui.dialog.MIUIDialog
import com.setoskins.hook.BuildConfig.BUILD_TIME
import com.setoskins.hook.BuildConfig.BUILD_TYPE
import com.setoskins.hook.BuildConfig.VERSION_NAME
import com.setoskins.hook.R
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.random.Random

@BMPage("about_module", "About Module", hideMenu = false)
class AboutPage : BasePage() {
    override fun onCreate() {

          
        ImageWithText(
            authorHead = getDrawable(R.drawable.setohooklogo),
            authorName = getString(R.string.app_name),
            authorTips = "${
                SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss",
                    Locale.getDefault()
                ).format(BUILD_TIME.toLong())
            }\n${VERSION_NAME}(${BUILD_TYPE})",
            onClickListener = {
                activity.startActivity(
                    Intent(
                        ACTION_VIEW,
                        parse("https://github.com/SetoSKins")
                    )
                )
            }
        )
        Line()
        TitleText(textId = R.string.developer)
        ImageWithText(
            authorHead = getDrawable(R.drawable.setoskins),
            authorName = "SetoSkins",
            authorTips = "愿光阴流转，见证成长，时光做证。",
            onClickListener = {
                activity.startActivity(
                    Intent(
                        ACTION_VIEW,
                        parse("mailto:SetoSkins@qq.com")
                    )
                )
            })



        ImageWithText(
            authorHead = getDrawable(R.drawable.bilibili6),
            authorName = "bilibili",
            authorTips = "@烟语_SetoSkins",
            onClickListener = {

                val uri =
                    parse("https://space.bilibili.com/15421963")
                val intent = Intent(ACTION_VIEW, uri)
                activity.startActivity(intent)

            })
        Line()
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.quote,
                onClickListener = { showFragment("thank") })
        )

        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.forum,
                onClickListener = {
                    try {
                        val uri =
                            parse("https://hub.cdnet.run/group/show/41")
                        val intent = Intent(ACTION_VIEW, uri)
                        Toast.makeText(activity, "欢迎加入！", Toast.LENGTH_LONG)
                            .show() // 添加Toast
                        activity.startActivity(intent)
                    } catch (e: Exception) {
                        makeText(activity, R.string.fail, LENGTH_SHORT).show()
                    }
                })
        )

        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.Telegram,
                onClickListener = {
                    activity.startActivity(
                        Intent(
                            ACTION_VIEW,
                            parse("https://t.me/SetoHook_Chat")
                        )
                    )
                }
            )
        )
    }

}


