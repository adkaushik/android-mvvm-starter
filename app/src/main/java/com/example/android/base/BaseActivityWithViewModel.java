package com.example.android.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.BR;

public abstract class BaseActivityWithViewModel<DB extends ViewDataBinding, VM extends ViewModel> extends BaseActivity<DB> {
    public VM viewModel;

    public abstract Class<VM> getViewModel();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(getViewModel());
        binding.setVariable(BR.viewmodel, viewModel);
    }


}