package com.example.testappkotlin.Network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val BASE_URl = "https://rickandmortyapi.com/"
    var api: RetrofitService? = null
    var retrofit: Retrofit? = null
    fun getRetrofitInstance(): RetrofitService {
        if (api == null) {
            retrofit = Retrofit.Builder().baseUrl(BASE_URl)

                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            api = retrofit!!.create(RetrofitService::class.java)
        }
        return api!!
    }

}