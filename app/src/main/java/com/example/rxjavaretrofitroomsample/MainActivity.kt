package com.example.rxjavaretrofitroomsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rxjavaretrofitroomsample.Retro.RetroClass
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(), MainActivityContract.View {


    var TAG = MainActivity::class.java.simpleName
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityPresenter = MainActivityPresenter(this)

        invokePresenterToCallApi()

        mainActivityPresenter.getDataFromDatabase()?.let {
            mainActivityPresenter.getDataFromDatabase()!!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {articleList -> Log.i(TAG,"from database----->\n"+articleList.toString())},
                    {error -> Log.e(TAG,error.message)}
                )
        }

    }

    override fun invokePresenterToCallApi() {
        mainActivityPresenter.callApiInPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainActivityPresenter.onActivityDestroy()
    }
}
