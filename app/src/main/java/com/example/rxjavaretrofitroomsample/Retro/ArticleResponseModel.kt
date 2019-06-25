package com.example.rxjavaretrofitroomsample.Retro

import com.google.gson.annotations.SerializedName

data class ArticleResponseModel (@SerializedName("response") var response : ArticleModel)

data class ArticleModel(@SerializedName("docs") var docs : List<DocumentModel>)

data class DocumentModel(@SerializedName("snippet") var snippet:String,
                         @SerializedName("multimedia") var multimedia:List<MultiMediaModel>)

data class MultiMediaModel(@SerializedName("url") var url:String)