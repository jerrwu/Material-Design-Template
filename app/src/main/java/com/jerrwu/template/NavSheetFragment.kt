package com.jerrwu.template

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.nav_sheet.*
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.net.Uri
import android.preference.PreferenceManager
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat


class NavSheetFragment : BottomSheetDialogFragment() {
    private var fragmentView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.nav_sheet, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)

        val nameString = prefs.getString("name", "User")
        bottom_sheet_account_text_1.text = nameString

        settingsButton.setOnClickListener {
            val intent = Intent(activity, SettingsActivity::class.java)
            startActivity(intent)
            closeNavSheet()
        }

        docButton.setOnClickListener {
            val uri = Uri.parse("https://github.com/jerrwu/Material-Design-Template/blob/master/README.md")
            val intentBuilder = CustomTabsIntent.Builder()
            intentBuilder.setToolbarColor(context.let { ContextCompat.getColor(it!!, R.color.colorPrimary) })
            intentBuilder.setShowTitle(true)
            val customTabsIntent = intentBuilder.build()
            customTabsIntent.launchUrl(activity, uri)
            closeNavSheet()
        }

        helpButton.setOnClickListener {
            val uri = Uri.parse("https://github.com/jerrwu/Material-Design-Template/issues")
            val intentBuilder = CustomTabsIntent.Builder()
            intentBuilder.setToolbarColor(context.let { ContextCompat.getColor(it!!, R.color.colorPrimary) })
            intentBuilder.setShowTitle(true)
            val customTabsIntent = intentBuilder.build()
            customTabsIntent.launchUrl(activity, uri)
            closeNavSheet()
        }

        bottomSheetAccountButton.setOnClickListener {
            val intent = Intent(activity, AccountActivity::class.java)
            startActivity(intent)
            closeNavSheet()
        }
    }

    private fun closeNavSheet() {
        activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
    }
}