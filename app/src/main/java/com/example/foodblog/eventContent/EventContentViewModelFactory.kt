package com.example.foodblog.eventContent

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodblog.database.EventDatabaseDao
import java.lang.IllegalArgumentException

class EventContentViewModelFactory (
    private val dataSource: EventDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventContentViewModel::class.java)){
            return EventContentViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}