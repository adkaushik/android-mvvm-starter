package com.example.android.base;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<Type extends RecyclerView.ViewHolder, Data> extends RecyclerView.Adapter<Type>{
    public abstract void setData(List<Data> data);

}
