package com.example.testappkotlin.DatabaseRoom


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appdata")
class DataEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo( name = "id")
    val id:Int =0
    @ColumnInfo( name = "name")
    val names:String? = null
    @ColumnInfo( name = "endData")
    val endData:String? = null
}