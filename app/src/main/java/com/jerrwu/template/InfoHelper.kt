package com.jerrwu.template

import android.app.Activity
import android.app.Dialog
import android.os.Build
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import android.app.AlarmManager
import android.content.Context.ALARM_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.app.PendingIntent
import android.content.Context
import kotlin.system.exitProcess


object InfoHelper {
    fun getGreeting(time: String): String {
        return when (time.toInt()) {
            in 5 downTo 0 -> "Happy early morning / late night!"
            in 10 downTo 6 -> "Have a good morning!"
            in 13 downTo 11 -> "It's lunch time!"
            in 17 downTo 14 -> "Enjoy a beautiful afternoon!"
            in 21 downTo 18 -> "Have a wonderful evening!"
            in 24 downTo 23 -> "It's getting late!"
            else -> "hie..."
        }
    }

    fun hasNavBar(activity: Activity?): Boolean {
        val temporaryHidden = activity!!.window.decorView.visibility and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION != 0
        if (temporaryHidden) return false
        val decorView = activity.window.decorView
        decorView.rootWindowInsets?.let{
            return it.stableInsetBottom != 0
        }
        return true
    }

    fun showDialog(title: String, textYes: String, textNo: String, activity: Activity) {
        val dialog = Dialog(activity, R.style.DialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_dialogue)
        val body = dialog.findViewById(R.id.dialogueBody) as TextView
        body.text = title
        val yesBtn = dialog.findViewById(R.id.yesBtn) as Button
        yesBtn.text = textYes
        val noBtn = dialog.findViewById(R.id.noBtn) as Button
        noBtn.text = textNo
        yesBtn.setOnClickListener {
            dialog.dismiss()
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }
}