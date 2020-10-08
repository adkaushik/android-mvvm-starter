package com.example.android.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;

import com.example.android.base.BaseViewModel;
import com.example.android.base.SingleLiveEvent;
import com.example.android.model.Post;
import com.example.android.repository.DataSource;
import com.example.android.repository.Repository;

import java.util.List;

public class HomeViewModel extends BaseViewModel<Post> {

    private final Repository repository;

    @ViewModelInject
    HomeViewModel(Repository repository) {
        this.repository = repository;
    }

    public void getAllPosts() {
        shimmerEvent.setValue(true);
        repository.getAllPosts(new DataSource.NetworkResponseCallback<List<Post>>() {
            @Override
            public void getPaginationResponse(List<Post> paginationResponse) {
                // There is no pagination
            }

            @Override
            public void getResponse(List<Post> response) {
                shimmerEvent.setValue(false);
                if (response.size() == 0) {
                    isEmpty.set(true);
                } else {
                    isEmpty.set(false);
                }
                items.addAll(response);
            }

            @Override
            public void handleFailure(String apiName, int statusCode) {
                shimmerEvent.setValue(false);
                isEmpty.set(true);
            }
        });
    }
}