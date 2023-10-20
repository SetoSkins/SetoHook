package com.setoskins.hook.activity.pages

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.activity.MIUIActivity.Companion.safeSP
import cn.fkj233.ui.activity.annotation.BMMainPage
import cn.fkj233.ui.activity.data.BasePage
import cn.fkj233.ui.activity.view.SpinnerV
import cn.fkj233.ui.activity.view.SwitchV
import cn.fkj233.ui.activity.view.TextSummaryV
import cn.fkj233.ui.dialog.MIUIDialog
import com.setoskins.hook.R
import com.setoskins.hook.activity.MainActivity.Companion.showToast
import java.util.Random


@SuppressLint("NonConstantResourceId")
@BMMainPage(title = "SetoHook")
class MainPage : BasePage() {


    override fun onCreate() {
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.powerkeeper,
                onClickListener = { showFragment("PowerkeeperPage") })
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.securitycenter,
                onClickListener = { showFragment("SecuritycenterPage")
                })
        )

        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.misound,
                onClickListener = { showFragment("SoundPage") })
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.UnlockSetting,
                onClickListener = { showFragment("UnlockSetting") })
        )


        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.OtherPage,
                onClickListener = { showFragment("OtherPage") })
        )
        Line()
        TitleText(textId = R.string.Monet_tips)
        val monetBinding = GetDataBinding({
            safeSP.getBoolean(
                "MonetSelection",
                false
            )
        }) { view, flags, data ->
            if (flags == 1) view.visibility = if (data as Boolean) View.VISIBLE else View.GONE
        }
        TextSummaryWithSwitch(
            TextSummaryV(
                textId = R.string.Monet,
            ), SwitchV("MonetSelection", false, dataBindingSend = monetBinding.bindingSend)
        )


        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.your_theme_accent_color,
                onClickListener = {
                    MIUIDialog(activity) {
                        setTitle(R.string.your_theme_accent_color)
                        setEditText(
                            "",
                            "${activity.getString(R.string.current)}${
                                safeSP.getString("your_theme_accent_color", "#0d84ff")
                            }"
                        )
                        setLButton(textId = R.string.cancel) {
                            dismiss()
                        }
                        setRButton(textId = R.string.done) {
                            if (getEditText() != "") {
                                safeSP.putAny(
                                    "your_theme_accent_color",
                                    getEditText()
                                )
                            }
                            dismiss()
                        }
                    }.show()
                }), dataBindingRecv = monetBinding.binding.getRecv(1)
        )
        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.your_theme_neutral_color,
                onClickListener = {
                    MIUIDialog(activity) {
                        setTitle(R.string.your_theme_neutral_color)
                        setEditText(
                            "",
                            "${activity.getString(R.string.current)}${
                                safeSP.getString("your_theme_neutral_color", "#A6CDE7")
                            }"
                        )
                        setLButton(textId = R.string.cancel) {
                            dismiss()
                        }
                        setRButton(textId = R.string.done) {
                            if (getEditText() != "") {
                                safeSP.putAny(
                                    "your_theme_neutral_color",
                                    getEditText()
                                )
                            }
                            dismiss()
                        }
                    }.show()
                }), dataBindingRecv = monetBinding.binding.getRecv(1)
        )
        TextSummaryWithSpinner(
            TextSummaryV(
                textId = R.string.Monet2,
            ),
            SpinnerV(safeSP.getString("CustomStyle", "默认")) {
                add("关闭") {
                    safeSP.putAny("CustomStyle", "关闭")
                    Toast.makeText(activity, "关闭", Toast.LENGTH_SHORT).show()
                    val command = "su -c 'settings put secure theme_customization_overlay_packages '{\"android.theme.customization.theme_style\":\"null\"}''"
                    val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                    process.waitFor()
                }
                add("TONAL_SPOT") {
                    safeSP.putAny("CustomStyle", "TONAL_SPOT")
                    Toast.makeText(activity, "TONAL_SPOT", Toast.LENGTH_SHORT).show()
                    val suCommand = "su -c 'settings put secure theme_customization_overlay_packages '{\"android.theme.customization.theme_style\":\"TONAL_SPOT\"}''"
                    val suProcess = Runtime.getRuntime().exec(arrayOf("sh", "-c", suCommand))
                    suProcess.waitFor()
                }
                add("SPRITZ") {
                    safeSP.putAny("CustomStyle", "SPRITZ")
                    Toast.makeText(activity, "SPRITZ", Toast.LENGTH_SHORT).show()
                    val suCommand = "su -c 'settings put secure theme_customization_overlay_packages '{\"android.theme.customization.theme_style\":\"SPRITZ\"}''"
                    val suProcess = Runtime.getRuntime().exec(arrayOf("sh", "-c", suCommand))
                    suProcess.waitFor()
                }
                add("VIBRANT") {
                    safeSP.putAny("CustomStyle", "VIBRANT")
                    Toast.makeText(activity, "VIBRANT", Toast.LENGTH_SHORT).show()
                    val suCommand = "su -c 'settings put secure theme_customization_overlay_packages '{\"android.theme.customization.theme_style\":\"VIBRANT\"}''"
                    val suProcess = Runtime.getRuntime().exec(arrayOf("sh", "-c", suCommand))
                    suProcess.waitFor()
                }
                add("EXPRESSIVE") {
                    safeSP.putAny("CustomStyle", "EXPRESSIVE")
                    Toast.makeText(activity, "EXPRESSIVE", Toast.LENGTH_SHORT).show()
                    val suCommand = "su -c 'settings put secure theme_customization_overlay_packages '{\"android.theme.customization.theme_style\":\"EXPRESSIVE\"}''"
                    val suProcess = Runtime.getRuntime().exec(arrayOf("sh", "-c", suCommand))
                    suProcess.waitFor()
                }
                add("RAINBOW") {
                    safeSP.putAny("CustomStyle", "RAINBOW")
                    Toast.makeText(activity, "RAINBOW", Toast.LENGTH_SHORT).show()
                    val suCommand = "su -c 'settings put secure theme_customization_overlay_packages '{\"android.theme.customization.theme_style\":\"RAINBOW\"}''"
                    val suProcess = Runtime.getRuntime().exec(arrayOf("sh", "-c", suCommand))
                    suProcess.waitFor()
                }
                add("FRUIT_SALAD") {
                    safeSP.putAny("CustomStyle", "FRUIT_SALAD")
                    Toast.makeText(activity, "FRUIT_SALAD", Toast.LENGTH_SHORT).show()
                    val suCommand = "su -c 'settings put secure theme_customization_overlay_packages '{\"android.theme.customization.theme_style\":\"FRUIT_SALAD\"}''"
                    val suProcess = Runtime.getRuntime().exec(arrayOf("sh", "-c", suCommand))
                    suProcess.waitFor()
                }
            })

        TitleText("特殊")





        TextSummaryWithSpinner(
            TextSummaryV(
                textId = R.string.MIUILOGO,
            ),
            SpinnerV(safeSP.getString("MIUILOGO", "默认")) {
                add("开启") {
                    safeSP.putAny("MIUILOGO", "开启")
                    val suCommand = "su -c 'echo \"#!/system/bin/sh\\nwait_until_login() {\\nwhile [ ! -d \\\"/sdcard/Android\\\" ]; do\\nsleep 1\\ndone\\nchmod 777 /data/adb/service.d/\\n}\\nwait_until_login\\nsettings put system key_miui_mod_icon_enable 1\" > /data/adb/service.d/SetoHook.sh'"
                    val suProcess = Runtime.getRuntime().exec(arrayOf("sh", "-c", suCommand))
                    suProcess.waitFor()
                }
                add("关闭") {
                    safeSP.putAny("MIUILOGO", "关闭")
                val command = "su -c 'rm -rf /data/adb/service.d/SetoHook.sh'"
                val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                process.waitFor()
            }

        })
        TextSummaryWithSpinner(
            TextSummaryV(
                textId = R.string.RotationButton,
            ),
            SpinnerV(safeSP.getString("RotationButton", "默认")) {
                add("开启") {
                    safeSP.putAny("RotationButton", "开启")
                    val command = "su -c 'settings put secure show_rotation_suggestions 1'"
                    val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                    process.waitFor()
                }
                add("关闭") {
                    safeSP.putAny("RotationButton", "关闭")
                    val command = "su -c 'settings put secure show_rotation_suggestions 0'"
                    val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
                    process.waitFor()
                }
            })

        Line()
        TitleText(textId = R.string.more)


        TextSummaryWithArrow(
            TextSummaryV(
                textId = R.string.about_module,
                tips = getString(R.string.about_module_summary),
                onClickListener = { showFragment("about_module") })
        )

    }

}