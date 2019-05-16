package com.example.rxjavaretrofitroomsample.Room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.rxjavaretrofitroomsample.BrewaryModel
import io.reactivex.Flowable

@Dao
interface BrewaryDao {

    @Query("SELECT * FROM Brewary")
    fun getAllBrewaries() : Flowable<List<BrewaryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(brewaryList: List<BrewaryModel>)

    @Query("DELETE FROM Brewary")
    fun deleteAll()
}