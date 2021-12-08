package com.example.testappkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testappkotlin.Adapters.DataRecyclerAdapter
import com.example.testappkotlin.DatabaseRoom.DataRoomDb
import com.example.testappkotlin.Models.DataObject
import com.example.testappkotlin.ViewModels.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dataViewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerDataList.layoutManager = LinearLayoutManager(this)
        initApi()

       loadData()
    }



    fun initApi() {
        dataViewModel = ViewModelProvider(this)[DataViewModel::class.java]
        dataViewModel.getDataFromApi()
        dataViewModel.dataList.observe(this, Observer{
            recyclerDataList.adapter = DataRecyclerAdapter(it)
        })
    }


    fun loadData() {
        dataViewModel.getDataFromApi()
    }
fun insertDb(){
    dataViewModel.dataList.observe(this, Observer {
        dataViewModel.insertAllToDb(it)

    })
}

//    fun getDataFromDb {
//    dataViewModel.getAllDb()
//    }
}