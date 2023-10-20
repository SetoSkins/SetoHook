package com.setoskins.hook.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.setoskins.hook.activity.pages.MainPage
import com.setoskins.hook.activity.pages.AboutPage
import com.setoskins.hook.activity.pages.MenuPage
import com.setoskins.hook.activity.pages.PowerkeeperPage
import com.setoskins.hook.activity.pages.SoundPage
import com.setoskins.hook.activity.pages.ThankList
import com.setoskins.hook.utils.key.BackupUtils.CREATE_DOCUMENT_CODE
import com.setoskins.hook.utils.key.BackupUtils.OPEN_DOCUMENT_CODE
import com.setoskins.hook.utils.key.BackupUtils.handleCreateDocument
import com.setoskins.hook.utils.key.BackupUtils.handleReadDocument
import cn.fkj233.ui.activity.MIUIActivity
import cn.fkj233.ui.dialog.MIUIDialog
import com.setoskins.hook.BuildConfig
import com.setoskins.hook.R
import com.setoskins.hook.activity.pages.BmPage
import com.setoskins.hook.activity.pages.OtherPage
import com.setoskins.hook.activity.pages.SecuritycenterPage
import com.setoskins.hook.activity.pages.UnlockSetting
import java.io.IOException


class MainActivity : MIUIActivity() {

    private lateinit var preferences: SharedPreferences
    private var showDialog = true  // 初始化为 true，表示第一次打开应用时显示
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var activity: MIUIActivity
        private val handler by lazy { Handler(Looper.getMainLooper()) }
        fun showToast(string: String) {
            Log.d("BlockMIUI", "Show Toast: $string")
            handler.post {
                Toast.makeText(activity, string, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        preferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
        val showDialogFlag = preferences.getBoolean("showDialog", true)
        MIUIActivity.safeSP.putAny("SafeMode", "关闭")
        if (BuildConfig.DEBUG) {
            // Do something when running in debug mode
        } else {
            checkLSPosed()
            checkRootPermission()
        }



        if (showDialogFlag) {  // 只在 showDialogFlag 为 true 时显示弹窗
            abc()
        }
    }



    private fun checkRootPermission() {
        try {
            val command = "su -c 'pm clear --cache-only com.miui.securitymanager'"
            val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
            val exitCode = process.waitFor()

            if (exitCode == 0) {

            } else {
                // 执行失败
                MIUIDialog(this) {
                    setTitle(R.string.error)
                    setMessage(R.string.root_warning)
                    setCancelable(false)
                    setRButton(R.string.done) {
                        finishAffinity()
                    }
                }.show()
            }
        } catch (e: IOException) {
            // 捕获 IO 异常
            MIUIDialog(this) {
                setTitle(R.string.error)
                setMessage(R.string.root_warning)
                setCancelable(false)
                setRButton(R.string.done) {
                    finishAffinity()
                }
            }.show()
        }
    }
    @SuppressLint("WorldReadableFiles")
    private fun checkLSPosed() {
        try {

            setSP(getSharedPreferences("config", MODE_WORLD_READABLE))
        } catch (exception: SecurityException) {
            MIUIDialog(this) {
                setTitle(R.string.warning)
                setMessage(R.string.not_support)
                setCancelable(false)
                setRButton(R.string.done) {
                    dismiss()
                }
            }.show()
        }
    }




    private fun abc() {
        showDialog = false  // 设置为 false，确保之后不再显示弹窗
        MIUIDialog(this) {

            setTitle(R.string.warning)
            setMessage(R.string.Splash_Tips)
            setCancelable(false)
            setLButton(R.string.Disagree) {
                System.exit(0)

            }
            setRButton(R.string.Agree) {
                preferences.edit().putBoolean("showDialog", false).apply()
                dismiss()
                val toast = Toast.makeText(activity, "记得把APP给予Root权限", Toast.LENGTH_LONG)
                toast.show()
            }
        }.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null && resultCode == RESULT_OK) {
            when (requestCode) {
                CREATE_DOCUMENT_CODE -> {
                    handleCreateDocument(activity, data.data)
                }

                OPEN_DOCUMENT_CODE -> {
                    handleReadDocument(activity, data.data)
                }
            }
        }
    }

    init {
        activity = this
        registerPage(MainPage::class.java)
        registerPage(AboutPage::class.java)
        registerPage(ThankList::class.java)
        registerPage(SoundPage::class.java)
        registerPage(PowerkeeperPage::class.java)
        registerPage(MenuPage::class.java)
        registerPage(UnlockSetting::class.java)
        registerPage(SecuritycenterPage::class.java)
        registerPage(OtherPage::class.java)
        registerPage(BmPage::class.java)

    }
}
