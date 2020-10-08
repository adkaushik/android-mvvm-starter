package com.example.android.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.android.model.Post;
import com.example.android.model.PostEntitiy;

import java.util.List;

/**
 * Created by Kaushik Annangi on October 8th, 2020
 */

@Dao
public interface PostDao {

    @Insert
    void insertPost(PostEntitiy post);

    @Query("DELETE FROM posts_table WHERE id = :postId")
    void deletePost(String postId);

    @Query("DELETE FROM posts_table")
    void deleteAll();

    @Query("SELECT * FROM posts_table")
    public List<PostEntitiy> getAllPosts();
}
