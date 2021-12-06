package com.example.testappkotlin.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testappkotlin.DatabaseRoom.DataEntity
import com.example.testappkotlin.DatabaseRoom.DataRoomDb
import com.example.testappkotlin.Models.DataModel
import com.example.testappkotlin.Models.DataObject
import com.example.testappkotlin.Network.RetrofitInstance
import com.example.testappkotlin.Network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataViewModel(app:Application): AndroidViewModel(app) {
    var dataList = MutableLiveData<DataModel<List<DataObject>>>()
    var dataListFromDb = MutableLiveData<List<DataEntity>>()

    fun getDataFromApi(){
        val retrofit = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofit.getData().enqueue(object :Callback<DataModel<List<DataObject>>>{
            override fun onResponse(
                call: Call<DataModel<List<DataObject>>>,
                response: Response<DataModel<List<DataObject>>>
            ) {
               dataList.value = response.body()
            }

            override fun onFailure(call: Call<DataModel<List<DataObject>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    init{
        dataListFromDb = MutableLiveData()
    }
    fun getDataFromDbObservers():MutableLiveData<List<DataEntity>>{
        return dataListFromDb
    }
    fun getAllDataFromDb(){
        val dataDao = DataRoomDb.getAppDatabase((getApplication()))?.dataDao()
        val list = dataDao?.getAllDataInfo()
        dataListFromDb.postValue(list!!)
    }
    fun insertDataInfo(entity: DataEntity){
        val dataDao = DataRoomDb.getAppDatabase((getApplication())).dataDao()
        dataDao?.insertData(entity)
        getAllDataFromDb()
    }
    fun deleteDataInfo(entity: DataEntity){
        val dataDao = DataRoomDb.getAppDatabase((getApplication())).dataDao()
        dataDao?.deleteData(entity)
        getAllDataFromDb()
    }
    fun updateDataInfo(entity: DataEntity){
        val dataDao = DataRoomDb.getAppDatabase((getApplication())).dataDao()
        dataDao?.updateData(entity)
        getAllDataFromDb()
    }
}