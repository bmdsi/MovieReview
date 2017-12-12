package com.example.moviemagic.api.dao;

import com.example.moviemagic.api.UserDataSource;
import com.example.moviemagic.data.MovieData;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by kumar on 12/11/17.
 */

public class UserDataSourceImpl implements UserDataSource {

    private final UserDao userDao;
    private final String databaseName;

    public UserDataSourceImpl(UserDao userDao, String databaseName) {
        this.userDao = userDao;
        this.databaseName = databaseName;
    }

    @Override
    public Single<List<MovieData>> getFavMovies() {
        return userDao.getAllFav();
    }

    @Override
    public void insertMovie(MovieData movieData) {
        userDao.insertFavMovie(movieData);
    }

    @Override
    public void deleteMovie(MovieData movieData) {
        userDao.deleteFavMovie(movieData);
    }

    @Override
    public MovieData getFavByTitle(String title) {
        return userDao.getFavByTitle(title);
    }
}
