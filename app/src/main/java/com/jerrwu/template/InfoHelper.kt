package com.jerrwu.template

object InfoHelper {
    public fun getGreeting(time: String): String {
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
}