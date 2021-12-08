package com.example.testappkotlin.Models

import androidx.room.PrimaryKey

data class DataModel<T>(
    @PrimaryKey(autoGenerate = true)
    val uid:Int,
    val data: T,
    val total: Int
)
