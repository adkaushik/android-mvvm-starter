package com.example.android.repository;

import androidx.annotation.NonNull;

import com.example.android.model.Post;

import java.util.List;

/**
 * Created by Kaushik Annangi on 08,October,2020
 */

public interface DataSource {
    interface NetworkResponseCallback<T> {
        // meant to be used for paginated calls response
        void getPaginationResponse(T paginationResponse);
        void getResponse(T response);
        void handleFailure(String apiName, int statusCode);
    }

    void getAllPosts(@NonNull NetworkResponseCallback<List<Post>> callback);
}
