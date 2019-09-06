package com.jerrwu.template


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class StartFragment : Fragment() {
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    var cardList: ArrayList<Card> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var card1 = Card()
        card1.id = 0
        card1.title = "Image card"
        card1.content = "hie..."
        card1.ic = R.drawable.image_placeholder
        cardList.add(card1)

        var card2 = Card()
        card2.id = 1
        card2.title = "Non-image card"
        card2.content = "hi..........................................................................................................................................................................................."
        card2.ic = 0
        cardList.add(card2)

        for (i in 2..6) {
            val card = Card()
            card.id = i
            card.ic = R.drawable.ic_plus
            card.title = "Title $i"
            card.content = "this is text this is text this is text this is text this is text this is text this is text this is text this is text this is text this is text this is text "
            cardList.add(card)
        }

        mRecyclerView = activity!!.findViewById(R.id.recycler_view)
        var mLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mRecyclerView!!.layoutManager = mLayoutManager
        mAdapter = CardAdapter(cardList)
        mRecyclerView!!.adapter = mAdapter
    }

}
