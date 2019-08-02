package com.jerrwu.template

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RecyclerFragment: Fragment() {


//    val users = ArrayList<String>()
//    users.add("this")
//    users.add("is")
//    users.add("a")
//    users.add("recycler")
//    users.add("view")
//    users.add("it can be")
//    users.add("customized to")
//    users.add("handle different objects")
//
//    val objAdapter = CustomAdapter(users)
//
//    rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
//    rv.adapter = objAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.recyclerview_fragment, container, false)

    companion object {
        fun newInstance(): RecyclerFragment = RecyclerFragment()
    }
}