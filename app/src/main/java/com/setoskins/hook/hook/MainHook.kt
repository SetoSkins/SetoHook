package com.setoskins.hook.hook

import com.github.kyuubiran.ezxhelper.EzXHelper
import com.github.kyuubiran.ezxhelper.Log
import com.github.kyuubiran.ezxhelper.LogExtensions.logexIfThrow
import com.setoskins.hook.hook.hooks.BaseHook
import com.setoskins.hook.hook.hooks.android.BoostCameraIfNeeded
import com.setoskins.hook.hook.hooks.android.CheckBackgroundProcCompact
import com.setoskins.hook.hook.hooks.android.DarkModeForAllApps
import com.setoskins.hook.hook.hooks.android.Disablecachingapps

import com.setoskins.hook.hook.hooks.android.GameMemory
import com.setoskins.hook.hook.hooks.android.HandleAutoLockOff
import com.setoskins.hook.hook.hooks.android.HandleThermalKillProc
import com.setoskins.hook.hook.hooks.android.IsInVisibleRange
import com.setoskins.hook.hook.hooks.android.KillAdj
import com.setoskins.hook.hook.hooks.android.KillProcess
import com.setoskins.hook.hook.hooks.android.KillService
import com.setoskins.hook.hook.hooks.android.NStartPressureMonitor
import com.setoskins.hook.hook.hooks.android.PerformIdleMaintenance
import com.setoskins.hook.hook.hooks.android.ShellKillAll
import com.setoskins.hook.hook.hooks.aod.AodSummary
import com.setoskins.hook.hook.hooks.barrage.Barragenotification
import com.setoskins.hook.hook.hooks.barrage.Barragenotification2
import com.setoskins.hook.hook.hooks.misound.Harman
import com.setoskins.hook.hook.hooks.misound.Improvesound
import com.setoskins.hook.hook.hooks.misound.Increasesamplingrate
import com.setoskins.hook.hook.hooks.misound.Surround
import com.setoskins.hook.hook.hooks.powerkeeper.AutoKillAPP
import com.setoskins.hook.hook.hooks.powerkeeper.Makemilletstronger
import com.setoskins.hook.hook.hooks.powerkeeper.OOM
import com.setoskins.hook.hook.hooks.powerkeeper.PowerKeeperCloud
import com.setoskins.hook.hook.hooks.powerkeeper.RestrictAlarm
import com.setoskins.hook.hook.hooks.powerkeeper.ScreenClearApp
import com.setoskins.hook.hook.hooks.powerkeeper.Test
import com.setoskins.hook.hook.hooks.screenshot.SaveAsPng
import com.setoskins.hook.hook.hooks.securitycenter.BalanceMode
import com.setoskins.hook.hook.hooks.securitycenter.Dfps
import com.setoskins.hook.hook.hooks.securitycenter.Dsda
import com.setoskins.hook.hook.hooks.securitycenter.Memc
import com.setoskins.hook.hook.hooks.securitycenter.Ndds
import com.setoskins.hook.hook.hooks.settings.GPSLocation
import com.setoskins.hook.hook.hooks.settings.NoveltyHaptic
import com.setoskins.hook.hook.hooks.settings.OldNoveltyHaptic
import com.setoskins.hook.hook.hooks.systemui.ChargeTips
import com.setoskins.hook.hook.hooks.systemui.ControlCenterStyle
import com.setoskins.hook.hook.hooks.systemui.MonetSelection
import com.setoskins.hook.hook.hooks.theme.ThemeHook
import com.setoskins.hook.hook.utils.XSharedPreferences.getBoolean
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.IXposedHookZygoteInit
import de.robv.android.xposed.callbacks.XC_LoadPackage

private const val TAG = "SetoHook"
val PACKAGE_NAME_HOOKED = setOf(
    "com.miui.misound",
    "com.miui.powerkeeper",
    "com.xiaomi.barrage",
    "com.miui.securitycenter",
    "android",
    "com.miui.screenshot",
    "com.miui.aod",
    "com.android.settings",
    "com.xiaomi.misettings",
    "com.android.systemui",
    "com.android.camera",
//    "com.android.thememanager",
)

@Suppress("unused")
class MainHook : IXposedHookLoadPackage, IXposedHookZygoteInit {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName in PACKAGE_NAME_HOOKED) {

            // Init EzXHelper
            EzXHelper.initHandleLoadPackage(lpparam)
            EzXHelper.setLogTag(TAG)
            EzXHelper.setToastTag(TAG)

            // Init hooks
            when (EzXHelper.hostPackageName) {
                "com.miui.screenshot" -> {
                    initHook(SaveAsPng, "SaveAsPng")
                }
                "com.miui.aod" -> {
                    initHook(AodSummary, "AodSummary")
                }
                "android" -> {
                    // 暗黑
                    initHook(DarkModeForAllApps, "DarkModeForAllApps")
                    // 内存管理
                    initHook(BoostCameraIfNeeded, "BoostCameraIfNeeded")
                    initHook(Disablecachingapps, "Disablecachingapps")
                    initHook(GameMemory, "GameMemory")
                    initHook(HandleThermalKillProc, "HandleThermalKillProc")
                    initHook(KillAdj, "KillAdj")
                    initHook(HandleAutoLockOff, "HandleAutoLockOff")
                    initHook(KillService, "KillService")
                    initHook(KillProcess, "KillProcess")
                    initHook(PerformIdleMaintenance, "PerformIdleMaintenance")
                    initHook(ShellKillAll, "ShellKillAll")
                    initHook(NStartPressureMonitor, "NStartPressureMonitor")

                    initHook(CheckBackgroundProcCompact, "CheckBackgroundProcCompact")
                    initHook(IsInVisibleRange, "IsInVisibleRange")
                }

                "com.miui.powerkeeper" -> {
                    // 使Millet更加激进
                    initHook(Makemilletstronger, "Makemilletstronger")
                    // 禁止杀死Adj低的进程
                    initHook(OOM, "OOM")
                    // 电池优化
//                    initHook(BatteryOptimization, "BatteryOptimization")
                      // 定时解冻
                    initHook(RestrictAlarm, "RestrictAlarm")
                    // 禁止下放部分云端
                    initHook(PowerKeeperCloud, "PowerKeeperCloud")
                    // 杀后台
                    initHook(ScreenClearApp, "ScreenClearApp")
                    initHook(AutoKillAPP, "AutoKillAPP")
                      initHook(Test, "Test")
                }
                "com.android.settings" -> {
                    // 震动
                    initHook(NoveltyHaptic, "NoveltyHaptic")
                    initHook(OldNoveltyHaptic, "OldNoveltyHaptic")
                    // 高精度GPS
                    initHook(GPSLocation, "GPSLocation")
                }
                "com.android.systemui" -> {
                    // 莫奈取色
                    initHook(MonetSelection, "MonetSelection")
                    initHook(ControlCenterStyle, "ControlCenterStyle")
                    // 隐藏锁屏界面下充电的信息
                    initHook(ChargeTips, "ChargeTips")
                }
//                "com.android.thememanager" -> {
//                    initHook(ThemeHook, "ThemeHook")
//                }
                "com.android.thememanager" -> {
                    // 莫奈取色
                    initHook(ThemeHook, "ThemeHook")
                }
                "com.miui.misound" -> {
                  //  提升采样率
                    initHook(Increasesamplingrate, "Increasesamplingrate")
                    // 环绕音效
                    initHook(Surround, "Surround")
                    // 哈曼卡顿
                    initHook(Harman, "Harman")
                    //  提升音质
                    initHook(Improvesound, "Improvesound")
                }
                "com.miui.securitycenter" -> {
                    // 均衡性能模式
                    initHook(BalanceMode, "BalanceMode")
                   //游戏中禁用副卡
                    initHook(Ndds, "Ndds")
//                    // 应用权限
//                    initHook(ManagementMeasures, "ManagementMeasures")
                    // 开启视频Dfps
                        initHook(Dfps, "Dfps")
                    // 动态补偿
                    initHook(Memc, "Memc")
                    // 开启增强Dsda
                    initHook(Dsda, "Dsda")
                }
                "com.xiaomi.barrage" -> {
                    // 允许所有应用使用弹幕通知
                initHook(Barragenotification2, "Barragenotification2")
                    // 允许全局显示弹幕通知
                   initHook(Barragenotification, "Barragenotification")
                }
            }
        }
    }

    override fun initZygote(startupParam: IXposedHookZygoteInit.StartupParam) {
        EzXHelper.initZygote(startupParam)
    }

    private fun initHook(hook: BaseHook, key: String, defValue: Boolean = false) =
        initHook(hook, getBoolean(key, defValue))

    private fun initHook(hook: BaseHook, enable: Boolean = true) {
        if (enable) runCatching {
            if (hook.isInit) return
            hook.init()
            hook.isInit = true
            Log.ix("Inited hook: ${hook.javaClass.simpleName}")
        }.logexIfThrow("Failed init hook: ${hook.javaClass.simpleName}")
    }
}
