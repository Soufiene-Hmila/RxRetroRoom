package com.example.rxjavaretrofitroomsample.Retro;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {

    private static String BASE_URL="https://api.openbrewerydb.org";


    private static Retrofit getRetrofitInstance()
    {
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    public static ApiClient getApiService()
    {
        return getRetrofitInstance().create(ApiClient.class);
    }
}
