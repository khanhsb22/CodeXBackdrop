package com.example.myapplication3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.home_screen.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeScreen : Fragment() {

    lateinit var v: View
    lateinit var homeAdapter: HomeAdapter
    lateinit var listHomeItem: ArrayList<HomeItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.home_screen, container, false)

        fetchData()

        return v
    }

    fun fetchData() {
        with(v.recyclerView_home) {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
            listHomeItem = ArrayList()
            listHomeItem.add(HomeItem("Item 1", R.drawable.bumblebee_6105984_1920))
            listHomeItem.add(HomeItem("Item 2", R.drawable.cat_6095007_1920))
            listHomeItem.add(HomeItem("Item 3", R.drawable.crocus_6089299_1920))
            listHomeItem.add(HomeItem("Item 4", R.drawable.magical_6063087_1920))
            listHomeItem.add(HomeItem("Item 5", R.drawable.mountain_6086083_1920))
            listHomeItem.add(HomeItem("Item 6", R.drawable.sunrise_5863751_1920))
            homeAdapter = HomeAdapter(listHomeItem)

            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL).apply {
                this.setDrawable(context.getDrawable(R.drawable.divider_empty)!!)
            })

            v.recyclerView_home.adapter = homeAdapter
        }
    }
}