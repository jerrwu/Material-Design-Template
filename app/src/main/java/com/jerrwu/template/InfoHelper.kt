package com.jerrwu.template

import android.app.Activity
import android.os.Build
import android.view.View

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
}