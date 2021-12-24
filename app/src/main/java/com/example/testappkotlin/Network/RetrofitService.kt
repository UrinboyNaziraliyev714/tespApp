package com.example.testappkotlin.Network

import com.example.testappkotlin.Models.DataModel
import com.example.testappkotlin.Models.DataObject
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("api/character/")
    fun getData(): Observable<DataModel<List<DataObject>>>
}