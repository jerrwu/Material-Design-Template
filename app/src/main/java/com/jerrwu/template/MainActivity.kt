package com.jerrwu.template

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_sheet.*


class MainActivity : AppCompatActivity() {
    val fragment1: Fragment = StartFragment()
    val fragment2: Fragment = CentreFragment()
    val fragment3: Fragment = EndFragment()
    val navSheetFragment = NavSheetFragment()
    val fm = supportFragmentManager
    var active = fragment1

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.menu_home -> {
                    fm.beginTransaction()
                        .hide(active)
                        .show(fragment1)
                        .commit()
                    active = fragment1
                    searchButton.visibility = View.GONE
                    fab.show()
                    return@OnNavigationItemSelectedListener true
                }

                R.id.menu_search -> {
                    fm.beginTransaction()
                        .hide(active)
                        .show(fragment2)
                        .commit()
                    active = fragment2
                    searchButton.visibility = View.VISIBLE
                    fab.hide()
                    return@OnNavigationItemSelectedListener true
                }

                R.id.menu_messages -> {
                    fm.beginTransaction()
                        .hide(active)
                        .show(fragment3)
                        .commit()
                    active = fragment3
                    searchButton.visibility = View.GONE
                    fab.hide()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun showBottomSheetDialogFragment() {
        navSheetFragment.show(supportFragmentManager, navSheetFragment.tag)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val darkToggle = sharedPreferences.getString("dark_toggle", "2")?.toInt()
        when (darkToggle) {
            -1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (fragment in fm.fragments) {
            fm.beginTransaction().remove(fragment).commit()
        }

        fm.beginTransaction().add(R.id.frag_container, fragment3, "3").hide(fragment3).commit()
        fm.beginTransaction().add(R.id.frag_container, fragment2, "2").hide(fragment2).commit()
        fm.beginTransaction().add(R.id.frag_container, fragment1, "1").commit()

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottom_navigation.selectedItemId = R.id.menu_home

        accountButton.setOnClickListener {
            showBottomSheetDialogFragment()
        }

        PreferenceManager
            .setDefaultValues(this, R.xml.preferences, false)
    }
}

