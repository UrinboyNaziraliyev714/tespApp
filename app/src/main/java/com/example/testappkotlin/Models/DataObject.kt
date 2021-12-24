package com.example.testappkotlin.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "datainfo")
data class DataObject(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val status: String, // Dec 07, 2021
    val image: String, // https://s3.amazonaws.com/media.guidebook.com/service/b5bEbF3a3Xuw7uGMg0ww2NjdwRmykKWQJ0YVZD1k/logo.png
    val name: String, // TFBF Convention 2021
    val species: String, // guide
    val gender: String, // Dec 04, 2021
    val location: List<LocationData>, // Dec 04, 2021


)

