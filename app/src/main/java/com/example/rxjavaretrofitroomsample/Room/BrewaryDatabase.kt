package com.example.rxjavaretrofitroomsample.Room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.rxjavaretrofitroomsample.BrewaryModel

@Database(entities = [(BrewaryModel::class)], version = 1)
abstract class BrewaryDatabase : RoomDatabase() {

    abstract fun getBrewaryDao() : BrewaryDao
}