package com.example.myapplication3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.headphone_screen.view.*
import kotlinx.android.synthetic.main.home_screen.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HeadPhoneScreen : Fragment() {

    lateinit var v: View
    lateinit var headPhoneAdapter: HeadPhoneAdapter
    lateinit var listHeadPhoneItem: ArrayList<HeadPhoneItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.headphone_screen, container, false)

        fetchData()

        return v
    }

    fun fetchData() {
        with(v.recyclerView_headPhone) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            listHeadPhoneItem = ArrayList()
            listHeadPhoneItem.add(
                HeadPhoneItem(
                    "Item 1", R.drawable.girl_869213_1920,
                    "Description of item 1"
                )
            )
            listHeadPhoneItem.add(
                HeadPhoneItem(
                    "Item 2", R.drawable.headphone1,
                    "Description of item 2"
                )
            )
            listHeadPhoneItem.add(
                HeadPhoneItem(
                    "Item 3", R.drawable.headphone2,
                    "Description of item 3"
                )
            )
            listHeadPhoneItem.add(
                HeadPhoneItem(
                    "Item 4", R.drawable.headphone3,
                    "Description of item 4"
                )
            )
            listHeadPhoneItem.add(
                HeadPhoneItem(
                    "Item 5", R.drawable.headphone4,
                    "Description of item 5"
                )
            )
            listHeadPhoneItem.add(
                HeadPhoneItem(
                    "Item 6", R.drawable.headphone5,
                    "Description of item 6"
                )
            )
            headPhoneAdapter = HeadPhoneAdapter(listHeadPhoneItem)

            v.recyclerView_headPhone.adapter = headPhoneAdapter
        }
    }
}