package com.example.rxjavaretrofitroomsample

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Brewary")
data class BrewaryModel (

    @PrimaryKey
    @SerializedName("id") @ColumnInfo(name = "id") var id:Int,
    @SerializedName("name") @ColumnInfo(name = "name") var name:String,
    @SerializedName("brewery_type") @ColumnInfo(name = "brewery_type") var brewery_type:String

)