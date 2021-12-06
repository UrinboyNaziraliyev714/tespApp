package com.example.testappkotlin.Network

import com.example.testappkotlin.Models.DataModel
import com.example.testappkotlin.Models.DataObject
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/service/v2/upcomingGuides/")
    fun getData():Call<DataModel<List<DataObject>>>
}