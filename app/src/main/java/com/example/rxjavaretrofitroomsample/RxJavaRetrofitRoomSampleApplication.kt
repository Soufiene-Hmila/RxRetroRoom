package com.example.rxjavaretrofitroomsample

import android.app.Application
import android.arch.persistence.room.Room
import com.example.rxjavaretrofitroomsample.Room.BrewaryDatabase

class RxJavaRetrofitRoomSampleApplication : Application() {

    companion object {
        var database: BrewaryDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, BrewaryDatabase::class.java, "brewary_db")
            .fallbackToDestructiveMigration().build()
    }
}