package com.example.android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;
import com.example.android.base.BaseFragmentWithViewModel;
import com.example.android.databinding.HomeFragmentBinding;
import com.example.android.ui.adapters.PostsAdapter;
import com.example.android.viewmodel.HomeViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends BaseFragmentWithViewModel<HomeViewModel, HomeFragmentBinding> {


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public Class<HomeViewModel> getViewModel() {
        return HomeViewModel.class;
    }

    @Override
    public int getLayoutResource() {
        return R.layout.home_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        dataBinding.recyclerView.setLayoutManager(layoutManager);

        PostsAdapter postsAdapter = new PostsAdapter(getActivity());

        dataBinding.recyclerView.setAdapter(postsAdapter);

        viewModel.getAllPosts();

        return dataBinding.getRoot();
    }
}