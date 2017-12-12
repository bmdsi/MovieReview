package com.example.moviemagic.ui.moviedetail;

import com.example.moviemagic.ui.topmovies.TopMoviePresenterImpl;
import com.example.moviemagic.ui.topmovies.TopMoviesFragment;
import com.example.moviemagic.ui.topmovies.TopMoviesPresenter;
import com.example.moviemagic.ui.topmovies.TopMoviesView;
import com.example.moviemagic.ui.topmovies.TopMoviewInteractor;
import com.example.moviemagic.ui.topmovies.TopMoviewInteractorImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by kumar on 12/10/17.
 */

@Module
public abstract class MovieDetailModule {

    @Binds
    abstract MovieDetailView bindMovieDetailView(MovieDetailFragment fragment);

}
