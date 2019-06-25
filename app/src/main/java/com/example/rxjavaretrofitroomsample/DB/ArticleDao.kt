package com.example.rxjavaretrofitroomsample.DB

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface ArticleDao {

    //Every time the user data is updated, the Flowable object will emit automatically,
    // allowing you to update the UI based on the latest data.

    @Query("SELECT * FROM ArticleTable")
    fun getArticles(): Flowable<List<ArticleDBModel>>

    @Insert
    fun insertAll(articleList: List<ArticleDBModel>)

    @Query("DELETE FROM ArticleTable")
    fun deleteAll()
}