package com.example.testappkotlin.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testappkotlin.DatabaseRoom.DataRoomDb
import com.example.testappkotlin.Models.DataModel
import com.example.testappkotlin.Models.DataObject
import com.example.testappkotlin.Network.Repository
import com.example.testappkotlin.Network.RetrofitInstance
import com.example.testappkotlin.Network.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataViewModel : ViewModel() {
    var dataList = MutableLiveData<List<DataObject>>()

    val error =MutableLiveData<String>()
    val repository = Repository()
    fun getDataFromApi() {
        repository.getDataInfo(error,dataList)

    }


    fun getAllDb() {
        CoroutineScope(Dispatchers.Main).launch {
            dataList.value = withContext(Dispatchers.IO){
                DataRoomDb.getRoomDatabase().dataDao().getAllDataInfo() }!!
        }
    }

    fun insertAllToDb(items: List<DataObject>) {
        CoroutineScope(Dispatchers.IO).launch {
            DataRoomDb.getRoomDatabase().dataDao().insertData(items)

        }

    }

}