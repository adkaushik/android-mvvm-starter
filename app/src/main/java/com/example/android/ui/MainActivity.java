package com.example.android.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.android.R;
import com.example.android.base.BaseActivity;
import com.example.android.databinding.ActivityMainBinding;
import com.example.android.ui.fragments.HomeFragment;
import com.example.android.utils.CustomDownloader;

import java.io.File;

import dagger.hilt.android.AndroidEntryPoint;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

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

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


    }


}
