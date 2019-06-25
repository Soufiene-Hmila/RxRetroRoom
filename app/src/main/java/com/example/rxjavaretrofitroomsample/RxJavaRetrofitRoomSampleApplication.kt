package com.example.rxjavaretrofitroomsample

import android.app.Application
import android.arch.persistence.room.Room
import com.example.rxjavaretrofitroomsample.DB.ArticleDataBase

class RxJavaRetrofitRoomSampleApplication : Application() {

    companion object {
        var database: ArticleDataBase? = null
        var apiKey : String? = null
    }

    override fun onCreate() {
        super.onCreate()
        apiKey = getString(R.string.api_key)
        database =  Room.databaseBuilder(applicationContext, ArticleDataBase::class.java, "article_db")
            .fallbackToDestructiveMigration().build()
    }
}