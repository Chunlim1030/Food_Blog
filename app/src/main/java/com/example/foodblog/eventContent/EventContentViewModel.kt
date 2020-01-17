package com.example.foodblog.eventContent

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.foodblog.database.EventDatabaseDao
import com.example.foodblog.database.EventDetails
import kotlinx.coroutines.*

class EventContentViewModel (
    val database: EventDatabaseDao,
    application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var uploadTime = MutableLiveData<EventDetails?>()
    init {
        initializeUploadTime()
    }
    private fun initializeUploadTime() {
        uiScope.launch {
            uploadTime.value = getUploadTimeFromDatabase()
        }
    }
    private suspend fun getUploadTimeFromDatabase(): EventDetails? {
        return withContext(Dispatchers.IO) {
            var upload = database.getLatestEvent()
            if (upload?.uploadTimeMilli != upload?.uploadTimeMilli) {
                upload = null
            }
            upload
        }
    }


//    //====get data from user input============================
//    val eventName = add_eventName_editText.text.toString()
//    val eventDescription = add_eventDescription_editText.text.toString()
//    //======click handler for Add Event=================
//    fun onEventUploaded() {
//
//        uiScope.launch {
//
//            val newEvent = EventDetails(eventName,eventDescription)
//            insert(newEvent)
//            uploadTime.value = getUploadTimeFromDatabase()
//        }
//    }
//    private suspend fun insert(night: SleepNight) {
//        withContext(Dispatchers.IO) {
//            database.insert(night)
//        }
//    }
//    //=====================================================


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}