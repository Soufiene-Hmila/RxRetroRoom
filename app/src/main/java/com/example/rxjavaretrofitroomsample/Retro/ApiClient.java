package com.example.rxjavaretrofitroomsample.Retro;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ApiClient {

    @GET("/svc/search/v2/articlesearch.json")
    Single<ArticleResponseModel> getArticles(@Query("q") String q, @Query("api-key") String apiKey);

}



//https://api.openbrewerydb.org/breweries