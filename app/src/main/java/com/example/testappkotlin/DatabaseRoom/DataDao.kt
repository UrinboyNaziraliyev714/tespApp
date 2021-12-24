package com.example.testappkotlin.DatabaseRoom

import androidx.room.*
import com.example.testappkotlin.Models.DataModel
import com.example.testappkotlin.Models.DataObject

@Dao
interface DataDao {
    @Query("SELECT * FROM datainfo")
    fun getAllDataInfo(): List<DataObject>?
    @Query(" DELETE from datainfo ")
    fun deleteAllDataInfo()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data:List<DataObject>)




}