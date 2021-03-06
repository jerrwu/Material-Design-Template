package com.jerrwu.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.IntentFilter




class SettingsActivity : AppCompatActivity() {
    val key1 = "TOGGLE_DIALOG_KEY"

    private val mBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            InfoHelper.showDialog(
                "An app restart is recommended after changing this setting. Restart now?",
                "Restart", "Later",
                context, InfoHelper::restartApp, InfoHelper::dismissDialog)
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(mBroadcastReceiver, IntentFilter(key1))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(mBroadcastReceiver)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val settingsFragment = SettingsFragment()

        settingsBackButton.setOnClickListener {
            finish()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.settingsFrame, settingsFragment)
            .commit()
    }
}
