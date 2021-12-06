package com.example.testappkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testappkotlin.Adapters.DataRecyclerAdapter
import com.example.testappkotlin.DatabaseRoom.DataEntity
import com.example.testappkotlin.Models.DataModel
import com.example.testappkotlin.Models.DataObject
import com.example.testappkotlin.ViewModels.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dataViewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initApi()
        insetDb()
    }

    private fun insetDb() {
       val list:List<DataModel<List<DataObject>>> = ArrayList<>
    }

    fun initApi() {
        dataViewModel = ViewModelProvider(this)[DataViewModel::class.java]

        dataViewModel.getDataFromApi()
        dataViewModel.dataList.observe(this, {
            initAdapter(it)
        })
    }

    fun initAdapter(data: DataModel<List<DataObject>>) {
        recyclerDataList.layoutManager = LinearLayoutManager(this)
        val adapter = DataRecyclerAdapter(this, data)
        recyclerDataList.adapter = adapter

    }


    fun isNetworkConnectedDb() {
        dataViewModel = ViewModelProvider(this)[DataViewModel::class.java]

        dataViewModel.getDataFromDbObservers().observe(this, Observer {
            initAdapter(it)
        })

    }
}