package com.example.foodblog.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface EventDatabaseDao {
    @Insert
    fun insert(event: EventDetails)

    @Update
    fun update(event: EventDetails)

    @Query("SELECT * FROM event_details_table WHERE eventId = :key")
    fun get(key: Long): EventDetails?

    @Query("DELETE FROM event_details_table")
    fun clear()

    @Query("SELECT * FROM event_details_table ORDER BY eventId DESC LIMIT 1")
    fun getLatestEvent(): EventDetails?

    @Query("SELECT * FROM event_details_table ORDER BY eventId DESC")
    fun getAllEvent(): LiveData<List<EventDetails>>
}