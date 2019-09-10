package com.jerrwu.template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_new.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        setSupportActionBar(toolbar_new_bottom)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm a")
        val curHour: String =  current.format(formatter)
        activity_new_bottom_text.text = curHour

        newBackButton.setOnClickListener {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.activity_new_menu, menu)
        return true
    }
}
