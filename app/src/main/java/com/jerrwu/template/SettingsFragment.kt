package com.jerrwu.template


import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.*


class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)

        val darkToggle = sharedPreferences.getString("dark_toggle", "2")?.toInt()
        val darkPreference = findPreference("dark_toggle") as ListPreference?
        val versionPreference = findPreference("version") as Preference?
        val namePreference = findPreference("name") as EditTextPreference?
        var versionStr = "Error"
        sharedPreferences.registerOnSharedPreferenceChangeListener(onPreferenceChangeListener)

        preferenceScreen.removePreference(namePreference)

        when (darkToggle) {
            -1 -> darkPreference!!.summary = "Follow System"
            0 -> darkPreference!!.summary = "Set by Battery Saver"
            1 -> darkPreference!!.summary = "On"
            2 -> darkPreference!!.summary = "Off"
        }

        try {
            val pInfo = context?.packageManager?.getPackageInfo(activity?.packageName, 0)
            versionStr = pInfo?.versionName.toString()
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        versionPreference!!.summary = versionStr


    }

    var onPreferenceChangeListener: SharedPreferences.OnSharedPreferenceChangeListener =
        SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            if (key == "dark_toggle") {
                val darkPreference = findPreference(key) as ListPreference?
                val darkToggle = sharedPreferences.getString(key, "2")?.toInt()
                when (darkToggle) {
                    -1 -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                        darkPreference!!.summary = "Follow System"
                    }
                    0 -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
                        darkPreference!!.summary = "Set by Battery Saver"
                    }
                    1 -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        darkPreference!!.summary = "On"
                    }
                    2 -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        darkPreference!!.summary = "Off"
                    }
                }
            }
            else if (key == "bottomNavHide") {
                if (this.context == null) { Log.d("jerrdebug","uh oh!") }
                InfoHelper.showDialog("An app restart is recommended after changing this setting.",
                    "", "OK", this.context!!)
            }
            else if (key == "appBarHide") {
                InfoHelper.showDialog("An app restart is recommended after changing this setting.",
                    "", "OK", this.context!!)
            }
        }
}
