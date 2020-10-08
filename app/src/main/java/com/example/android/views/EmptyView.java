package com.example.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android.databinding.EmptyViewBinding;

public class EmptyView extends FrameLayout {

    private EmptyViewBinding emptyViewBinding;

    public EmptyView(@NonNull Context context) {
        super(context);
        init();
    }

    public EmptyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EmptyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public EmptyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        emptyViewBinding = EmptyViewBinding.inflate(inflater, this, true);
    }

    public void setTitle(String text) {
        emptyViewBinding.setTitle(text);
    }

    public void setTitle(int resource) {
        emptyViewBinding.setTitle(getContext().getResources().getString(resource));
    }

    public void setDescription(String description) {
        emptyViewBinding.setSubTitle(description);
    }

    public void setDescription(int resource) {
        emptyViewBinding.setSubTitle(getContext().getResources().getString(resource));
    }
}
