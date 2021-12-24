package com.example.testappkotlin.Models

import androidx.room.PrimaryKey

data class DataModel<T>(
    @PrimaryKey(autoGenerate = true)
    val info: T,
    val results: T,

)
