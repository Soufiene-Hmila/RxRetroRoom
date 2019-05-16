package com.example.rxjavaretrofitroomsample

import io.reactivex.Flowable

interface MainActivityContract {

    interface View{
        fun invokePresenterToCallApi()
    }

    interface Presenter{
        fun callApiInPresenter()
        fun getDataFromDatabase() : Flowable<List<BrewaryModel>>?
        fun onActivityDestroy()
    }
}