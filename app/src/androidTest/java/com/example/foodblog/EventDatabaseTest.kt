package com.example.foodblog


import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.foodblog.database.EventDatabase
import com.example.foodblog.database.EventDatabaseDao
import com.example.foodblog.database.EventDetails
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception


/**
 * This is not meant to be a full set of tests. For simplicity, most of your samples do not
 * include tests. However, when building the Room, it is helpful to make sure it works before
 * adding the UI.
 */

@RunWith(AndroidJUnit4::class)
class EventDatabaseTest {

    private lateinit var eventDao: EventDatabaseDao
    private lateinit var db: EventDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, EventDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        eventDao = db.eventDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetEvent() {
        val event = EventDetails(name = "ali event", description = "testing123")
        eventDao.insert(event)
        val latestEvent = eventDao.getLatestEvent()

    }
}
