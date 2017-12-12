package com.example.moviemagic.api.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.moviemagic.data.MovieData;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * DAO to access the cities from the database
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM MovieData ")
    Single<List<MovieData>> getAllFav();

    @Insert
    void insertFavMovie(MovieData movieData);

    @Delete
    void deleteFavMovie(MovieData movieData);

    @Query("SELECT * FROM MovieData WHERE displayTitle = :displayTitle")
    MovieData getFavByTitle(String displayTitle);

}
