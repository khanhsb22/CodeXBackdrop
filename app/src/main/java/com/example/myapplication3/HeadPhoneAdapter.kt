package com.example.myapplication3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.headphone_item.view.*
import kotlinx.android.synthetic.main.home_item.view.*

class HeadPhoneAdapter : RecyclerView.Adapter<HeadPhoneAdapter.ItemHolder> {

    var arrayList: ArrayList<HeadPhoneItem>

    constructor(list: ArrayList<HeadPhoneItem>) : super() {
        this.arrayList = list
    }

    class ItemHolder : RecyclerView.ViewHolder{

        var image_headphone: ImageView
        var title_headphone: TextView
        var description_headphone: TextView

        constructor(itemView: View) : super(itemView) {
            image_headphone = itemView.image_headphone
            title_headphone = itemView.title_headphone
            description_headphone = itemView.description_headphone
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var v: View = LayoutInflater.from(parent.context).inflate(R.layout.headphone_item, parent, false)
        var itemHolder = ItemHolder(v)

        return itemHolder
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = arrayList.get(holder.adapterPosition)
        holder.image_headphone.setImageResource(item.image)
        holder.title_headphone.text = item.title
        holder.description_headphone.text = item.desc
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}