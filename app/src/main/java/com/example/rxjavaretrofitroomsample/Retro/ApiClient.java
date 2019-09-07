package com.example.rxjavaretrofitroomsample.Retro;

import com.example.rxjavaretrofitroomsample.BrewaryModel;
import com.example.rxjavaretrofitroomsample.Model.Comment;
import com.example.rxjavaretrofitroomsample.Model.Photo;
import com.example.rxjavaretrofitroomsample.Model.Post;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.reactivex.Single;
import retrofit2.http.GET;

import java.util.List;

public interface ApiClient {

    @GET("/breweries")
    Single<List<BrewaryModel>> getAllBrewaryList();

    @GET("/photo")
    Single<List<Photo>> getAllPhotos();

    @GET("/posts/1")
    Single<Post> getFirstPost();

    @GET("/posts/1/comments")
    Single<List<Comment>> getCommentsForFirstPost();

}



//https://api.openbrewerydb.org/breweries