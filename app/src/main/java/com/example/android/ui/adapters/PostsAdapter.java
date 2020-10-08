package com.example.android.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.android.base.BaseAdapter;
import com.example.android.databinding.HomePostItemBinding;
import com.example.android.model.Post;
import com.example.android.ui.viewHolders.PostViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaushik on 2 Sep, 2020
 */
public class PostsAdapter extends BaseAdapter<PostViewHolder, Post> {
    private Context mContext;
    private ArrayList<Post> items;
    private HomePostItemBinding binding;

    public PostsAdapter(Context mContext) {
        this.mContext = mContext;
        this.items = new ArrayList<>();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = HomePostItemBinding.inflate(inflater,parent,false);
        return new PostViewHolder(binding, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.onBind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void setData(List<Post> list) {
        items = (ArrayList<Post>) list;
        notifyDataSetChanged();
    }
}
