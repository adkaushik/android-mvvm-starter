package com.example.android.ui.viewHolders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android.databinding.HomePostItemBinding;
import com.example.android.model.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private final Context context;
    private HomePostItemBinding itemBinding;

    public static PostViewHolder create(LayoutInflater inflater, ViewGroup parent, Context context) {

        HomePostItemBinding listItemBinding = HomePostItemBinding.inflate(inflater, parent, false);
        return new PostViewHolder(listItemBinding, context);
    }

    public PostViewHolder(HomePostItemBinding itemBinding, Context context) {
        super(itemBinding.getRoot());
        this.itemBinding = itemBinding;
        this.context = context;
    }

    public void onBind(Post post) {
        itemBinding.setPost(post);
    }
}