package com.example.rxjavaretrofitroomsample.DB

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "ArticleTable")
data class ArticleDBModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name = "snippet") var snippet: String,
    @ColumnInfo(name = "imageUrl") var imageUrl: String
)