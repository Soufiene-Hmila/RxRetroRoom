package com.example.rxjavaretrofitroomsample.Retro;

import com.example.rxjavaretrofitroomsample.BrewaryModel;
import io.reactivex.Single;
import retrofit2.http.GET;

import java.util.List;

public interface ApiClient {

    @GET("/breweries")
    Single<List<BrewaryModel>> getAllBrewaryList();
}



//https://api.openbrewerydb.org/breweries