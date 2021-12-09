package com.example.testappkotlin.DatabaseRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testappkotlin.Models.DataObject

@Database(entities = [DataObject::class], version = 1)
abstract class DataRoomDb : RoomDatabase(){
    abstract fun dataDao():DataDao

    companion object{
        private var INSTANCE:DataRoomDb? =null
        fun initRoomDatabase(context:Context) {
            if (INSTANCE==null){
                INSTANCE = Room.databaseBuilder<DataRoomDb>(
                    context.applicationContext,DataRoomDb::class.java,"AppDb").build()
            }

        }
        fun getRoomDatabase():DataRoomDb{
            return INSTANCE!!
        }
    }
}