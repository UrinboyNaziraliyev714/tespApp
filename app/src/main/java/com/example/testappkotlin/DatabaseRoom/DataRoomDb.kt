package com.example.testappkotlin.DatabaseRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataEntity::class], version = 1)
abstract class DataRoomDb : RoomDatabase(){
    abstract fun dataDao():DataDao?

    companion object{
        private var INSTANCE:DataRoomDb? =null
        fun getAppDatabase(context: Context):DataRoomDb{
            if (INSTANCE==null){
                INSTANCE = Room.databaseBuilder<DataRoomDb>(
                    context.applicationContext,DataRoomDb::class.java,"AppDb"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE!!
        }
    }
}