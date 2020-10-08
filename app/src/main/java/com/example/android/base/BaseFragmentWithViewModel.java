package com.example.android.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.BR;

public abstract class BaseFragmentWithViewModel<VM extends ViewModel, DB extends ViewDataBinding> extends BaseFragment<DB> {
    public VM viewModel;

    public abstract Class<VM> getViewModel();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(getViewModel());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        dataBinding.setVariable(BR.viewmodel, viewModel);

        return dataBinding.getRoot();
    }
}
