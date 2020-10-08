package com.example.android.binding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.base.BaseAdapter;

import java.util.List;

public class ListBindingAdapter {

    @BindingAdapter(value = "list")
    public static void setList(RecyclerView recyclerView, List list) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();

        if (adapter == null) return;

        if (list == null) return;

        if (adapter instanceof BaseAdapter) {
            ((BaseAdapter) adapter).setData(list);
        }
    }
}
