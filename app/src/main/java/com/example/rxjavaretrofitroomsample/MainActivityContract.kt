package com.example.rxjavaretrofitroomsample

import com.example.rxjavaretrofitroomsample.DB.ArticleDBModel
import io.reactivex.Flowable

interface MainActivityContract {

    interface View{
        fun invokePresenterToCallApi()
    }

    interface Presenter{
        fun callApiInPresenter()
        fun getDataFromDatabase() : Flowable<List<ArticleDBModel>>?
        fun onActivityDestroy()
    }
}