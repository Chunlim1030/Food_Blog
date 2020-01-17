package com.example.foodblog.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EventDetails::class], version = 1, exportSchema = false)
abstract class EventDatabase : RoomDatabase() {

    abstract val eventDatabaseDao: EventDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: EventDatabase? = null
        fun getInstane(context: Context): EventDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EventDatabase::class.java,
                        "event_history_databse"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}