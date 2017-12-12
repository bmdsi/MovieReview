package com.example.moviemagic.api;

import com.example.moviemagic.data.MovieData;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Interface for the city data store
 */

public interface UserDataSource {

    Single<List<MovieData>> getFavMovies();

    void insertMovie(MovieData movieData);

    void deleteMovie(MovieData movieData);

    MovieData getFavByTitle(String title);

}
