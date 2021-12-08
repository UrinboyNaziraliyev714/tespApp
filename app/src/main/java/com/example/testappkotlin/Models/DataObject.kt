package com.example.testappkotlin.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "datainfo")
data class DataObject(
    @PrimaryKey(autoGenerate = true)
    val uid:Int,
    val endDate: String, // Dec 07, 2021
    val icon: String, // https://s3.amazonaws.com/media.guidebook.com/service/b5bEbF3a3Xuw7uGMg0ww2NjdwRmykKWQJ0YVZD1k/logo.png
    val loginRequired: Boolean, // false
    val name: String, // TFBF Convention 2021
    val objType: String, // guide
    val startDate: String, // Dec 04, 2021
    val url: String, // /guide/188362

)
