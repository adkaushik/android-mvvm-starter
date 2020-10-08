package com.example.android.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android.model.PostEntitiy;

/**
 * Created by Kaushik Annangi on October 8th, 2020
 */
@Database(
        entities = {
                PostEntitiy.class
        },
        version = 1,
        exportSchema = false
)
public abstract class LocalDataBase extends RoomDatabase {

    public abstract PostDao postDao();
}
