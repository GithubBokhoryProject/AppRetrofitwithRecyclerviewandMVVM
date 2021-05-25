package com.example.appretrofitwithrecyclerviewandmvvm.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.appretrofitwithrecyclerviewandmvvm.pojo.ApiInterface;
import com.example.appretrofitwithrecyclerviewandmvvm.pojo.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostViewModel extends ViewModel {
MutableLiveData<List<Post>> listMutableLiveData=new MutableLiveData<>();

public void getData(){
    Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();
    ApiInterface apiInterface=retrofit.create(ApiInterface.class);
    Call<List<Post>> call=apiInterface.getPost();
    call.enqueue(new Callback<List<Post>>() {
        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
            listMutableLiveData.setValue(response.body());
        }

        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {

        }
    });
}
}
