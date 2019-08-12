package com.jerrwu.template

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.content.SharedPreferences



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        android.support.v7.preference.PreferenceManager
            .setDefaultValues(this, R.xml.preferences, false)

        val sharedPref = android.support.v7.preference.PreferenceManager
            .getDefaultSharedPreferences(this)
        val switchPref = sharedPref.getBoolean(getString(R.string.dark_toggle_key), false)
        Toast.makeText(
            this, switchPref.toString(),
            Toast.LENGTH_SHORT
        ).show()
    }
}
