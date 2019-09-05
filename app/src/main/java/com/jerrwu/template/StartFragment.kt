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

        for (i in 0..4) {
            val card = Card()
            card.id = i
            card.ic = R.drawable.ic_plus
            card.title = "Title $i"
            card.content = "kevin qi kevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qikevin qi"
            cardList.add(card)
        }

        mRecyclerView = activity!!.findViewById(R.id.recycler_view)
        var mLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mRecyclerView!!.layoutManager = mLayoutManager
        mAdapter = CardAdapter(cardList)
        mRecyclerView!!.adapter = mAdapter
    }

}
