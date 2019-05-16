package com.example.rxjavaretrofitroomsample

import android.util.Log
import com.example.rxjavaretrofitroomsample.Retro.RetroClass
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivityPresenter(view: MainActivityContract.View) : MainActivityContract.Presenter {

    val TAG = MainActivityPresenter::class.java.simpleName

    override fun callApiInPresenter() {
        DisposableManager.add(
            RetroClass.getApiService().allBrewaryList
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { brewaryList -> Log.i(TAG, "from api----->\n"+brewaryList.toString())
                        RxJavaRetrofitRoomSampleApplication.database?.let {
                            it.getBrewaryDao().deleteAll()
                            it.getBrewaryDao().insertAll(brewaryList)
                        }
                    },
                    { error -> Log.e(TAG, error.message) }
                )
        )
    }

    override fun getDataFromDatabase(): Flowable<List<BrewaryModel>>? {
        return RxJavaRetrofitRoomSampleApplication.database?.let {
            it.getBrewaryDao().getAllBrewaries()
        }
    }

    override fun onActivityDestroy() {
        DisposableManager.dispose()
    }



}