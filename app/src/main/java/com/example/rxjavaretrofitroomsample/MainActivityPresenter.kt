package com.example.rxjavaretrofitroomsample

import android.util.Log
import com.example.rxjavaretrofitroomsample.DB.ArticleDBModel
import com.example.rxjavaretrofitroomsample.Retro.RetroClass
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivityPresenter(view: MainActivityContract.View) : MainActivityContract.Presenter {

    val TAG = MainActivityPresenter::class.java.simpleName

    override fun callApiInPresenter() {
        DisposableManager.add(
            RetroClass.getApiService().getArticles("election", RxJavaRetrofitRoomSampleApplication.apiKey)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { articleResponseModel ->
                        Log.i(TAG, "from api----->\n" + articleResponseModel.toString())

                        val dbArticleList: MutableList<ArticleDBModel> = ArrayList()

                        for (article in articleResponseModel.response.docs) {

                            if(!article.multimedia.isNullOrEmpty()) {
                                dbArticleList.add(
                                    ArticleDBModel(
                                        null, article.snippet
                                        , "https://www.nytimes.com/" + article.multimedia[0].url
                                    )
                                )
                            }

                        }

                        RxJavaRetrofitRoomSampleApplication.database?.let {
                            it.getArticleDao().deleteAll()
                            it.getArticleDao().insertAll(dbArticleList)
                        }
                    },
                    { error -> Log.e(TAG, error.message) }
                )
        )
    }

    override fun getDataFromDatabase(): Flowable<List<ArticleDBModel>>? {
        return RxJavaRetrofitRoomSampleApplication.database?.let {
            it.getArticleDao().getArticles().switchMap { data -> Flowable.just(data) }
        }
    }

    override fun onActivityDestroy() {
        DisposableManager.dispose()
    }


}