package com.example.foodblog.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "event_details_table")
data class EventDetails(
    @PrimaryKey(autoGenerate = true)
    var eventId: Long = 0L,

    @ColumnInfo(name = "event_name")
    var name: String,

    @ColumnInfo(name = "event_description")
    var description: String,

    @ColumnInfo(name = "upload_time_milli")
    var uploadTimeMilli: Long = System.currentTimeMillis()
)