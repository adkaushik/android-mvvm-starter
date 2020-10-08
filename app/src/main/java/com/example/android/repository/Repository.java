package com.example.android.repository;

import androidx.annotation.NonNull;

import com.example.android.model.Post;
import com.example.android.network.ApiService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kaushik Annangi on 08,October,2020
 */

public class Repository implements DataSource {

    private ApiService apiService;

    @Inject
    public Repository(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getAllPosts(@NonNull NetworkResponseCallback<List<Post>> callback) {
        apiService.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.getResponse(response.body());
                } else {
                    callback.handleFailure("getAllPosts", response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                callback.handleFailure("getAllPosts", -1);
            }
        });
    }
}
