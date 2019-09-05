package com.jerrwu.template

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val mDataList: ArrayList<Card>) : RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cardTitle.text = mDataList[position].title
        holder.cardContent.text = mDataList[position].content
        holder.cardIc.setImageResource(mDataList[position].ic)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var cardTitle: TextView = itemView.findViewById<View>(R.id.card_title) as TextView
        internal var cardContent: TextView = itemView.findViewById<View>(R.id.card_content) as TextView
        internal var cardIc: ImageView = itemView.findViewById<View>(R.id.card_ic) as ImageView
    }
}