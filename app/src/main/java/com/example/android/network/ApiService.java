package com.example.android.network;

import com.example.android.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kaushik Annangi on 08,October,2020
 */
public interface ApiService {

    @GET("/posts")
    Call<List<Post>> getPosts();
}
