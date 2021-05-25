package com.example.appretrofitwithrecyclerviewandmvvm.pojo;

import com.example.appretrofitwithrecyclerviewandmvvm.pojo.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
   @GET("posts")
    public Call<List<Post>> getPost();
}
