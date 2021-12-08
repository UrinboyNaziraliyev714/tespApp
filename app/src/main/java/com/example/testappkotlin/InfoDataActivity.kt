package com.example.testappkotlin

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.testappkotlin.Models.DataObject
import com.example.testappkotlin.ViewModels.DataViewModel
import kotlinx.android.synthetic.main.activity_info_data.*

class InfoDataActivity : AppCompatActivity() {
    private lateinit var dataViewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_data)
        val item = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        val startdate = intent.getStringExtra("startDate")
        val endDate = intent.getStringExtra("endDate")

        Glide.with(this).load(item).into(imageinfo)

        tv_info.text = "Name:    "+name+"\n"+"StardDate:  "+startdate+"\n"+"endDate:  "+endDate

        //loadData()
//        for (li in dataViewModel.dataList.value!!)
//        {
//
//        }

    }
    fun loadData() {
        dataViewModel.getDataFromApi()
    }
}