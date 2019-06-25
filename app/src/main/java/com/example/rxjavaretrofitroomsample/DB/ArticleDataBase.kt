package com.example.rxjavaretrofitroomsample.DB

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [(ArticleDBModel::class)], version = 1)
abstract class ArticleDataBase : RoomDatabase(){
    abstract fun getArticleDao() : ArticleDao

}