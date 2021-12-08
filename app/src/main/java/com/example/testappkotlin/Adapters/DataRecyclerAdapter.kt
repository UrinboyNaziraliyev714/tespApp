package com.example.testappkotlin.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testappkotlin.InfoDataActivity
import com.example.testappkotlin.Models.DataModel
import com.example.testappkotlin.Models.DataObject
import com.example.testappkotlin.R

class DataRecyclerAdapter(var mList :List<DataObject>): RecyclerView.Adapter<DataRecyclerAdapter.MyHolderView>() {
    inner class MyHolderView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.imageData)
        val name:TextView = itemView.findViewById(R.id.tv_name)
        val cardView:CardView = itemView.findViewById(R.id.cardItem)
        val endDate:TextView = itemView.findViewById(R.id.tv_end_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyHolderView(view)
    }

    override fun onBindViewHolder(holder: MyHolderView, position: Int) {

        Glide.with(holder.itemView.context).asBitmap().load(mList[position].icon).into(holder.image)
       holder.name.text = mList[position].name
       holder.endDate.text = mList[position].endDate
        holder.cardView.setOnClickListener {
            val intent = Intent(it.context, InfoDataActivity::class.java)
            intent.putExtra("id",mList[position].uid)
           intent.putExtra("image",mList[position].icon)
           intent.putExtra("name",mList[position].name)
            intent.putExtra("startDate",mList[position].startDate)
            intent.putExtra("endDate",mList[position].endDate)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
      return mList.size
    }
}