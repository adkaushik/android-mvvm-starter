package com.example.android.di;

import android.app.Application;

import androidx.room.Room;

import com.example.android.db.LocalDataBase;
import com.example.android.db.PostDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

/**
 * Created by Kaushik Annangi on October 8th, 2020
 */

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static LocalDataBase provideLocalDB(Application application){
         return Room.databaseBuilder(application,LocalDataBase.class,"localDatabase.db")
                 .fallbackToDestructiveMigration()
                 .allowMainThreadQueries()
                 .build();
    }

    @Provides
    @Singleton
    public static PostDao providePostDao(LocalDataBase dataBase){
        return dataBase.postDao();
    }
}
