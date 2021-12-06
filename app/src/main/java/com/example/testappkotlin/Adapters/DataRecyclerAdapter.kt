package com.example.testappkotlin.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testappkotlin.Models.DataModel
import com.example.testappkotlin.Models.DataObject
import com.example.testappkotlin.R

class DataRecyclerAdapter(val context:Context,var mList :DataModel<List<DataObject>>): RecyclerView.Adapter<DataRecyclerAdapter.MyHolderView>() {
    inner class MyHolderView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.imageData)
        val name:TextView = itemView.findViewById(R.id.tv_name)
        val endDate:TextView = itemView.findViewById(R.id.tv_end_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyHolderView(view)
    }

    override fun onBindViewHolder(holder: MyHolderView, position: Int) {

        Glide.with(context).asBitmap().load(mList.data[position].icon).into(holder.image)
       holder.name.text = mList.data[position].name
       holder.endDate.text = mList.data[position].endDate
    }

    override fun getItemCount(): Int {
      return mList.data.size
    }
}