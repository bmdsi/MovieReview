package com.example.moviemagic.api.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.moviemagic.data.MovieData;

/**
 * Database to store user favs
 */

@Database(entities = MovieData.class, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao getCityDao();

    private static volatile UserDatabase INSTANCE;
    private static final String DB_NAME = "user.db";

    public static UserDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (UserDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase.class, DB_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
