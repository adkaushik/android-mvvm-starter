package com.example.android.ui;

import android.os.Bundle;

import com.example.android.R;
import com.example.android.base.BaseActivity;
import com.example.android.databinding.ActivityMainBinding;
import com.example.android.ui.fragments.HomeFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, HomeFragment.newInstance())
                .commit();
    }
}
