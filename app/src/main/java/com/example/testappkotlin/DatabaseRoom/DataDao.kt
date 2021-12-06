package com.example.testappkotlin.DatabaseRoom

import androidx.room.*

@Dao
interface DataDao {
    @Query("SELECT *FROM appdata ORDER BY id DESC")
    fun getAllDataInfo():List<DataEntity>?

    @Insert
    fun insertData(data:DataEntity?)

    @Delete
    fun deleteData(data:DataEntity?)
    @Update
    fun updateData(data:DataEntity?)

}