package com.example.myapplication3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.home_item.view.*

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ItemHolder> {

    var arrayList: ArrayList<HomeItem>

    constructor(list: ArrayList<HomeItem>) : super() {
        this.arrayList = list
    }

    class ItemHolder : RecyclerView.ViewHolder{

        var imageView_home: ImageView
        var textView_title_home: TextView

        constructor(itemView: View) : super(itemView) {
            imageView_home = itemView.image_home
            textView_title_home = itemView.title_home

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var v: View = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        var itemHolder = ItemHolder(v)

        return itemHolder
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = arrayList.get(holder.adapterPosition)
        holder.imageView_home.setImageResource(item.image)
        holder.textView_title_home.text = item.title
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}