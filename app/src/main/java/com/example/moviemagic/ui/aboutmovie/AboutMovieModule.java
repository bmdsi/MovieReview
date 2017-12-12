package com.example.moviemagic.ui.aboutmovie;

import com.example.moviemagic.ui.topmovies.TopMoviesFragment;
import com.example.moviemagic.ui.topmovies.TopMoviesView;

import dagger.Binds;
import dagger.Module;

/**
 * Dagger binds dependencies
 */

@Module
public abstract class AboutMovieModule {

    @Binds
    abstract AboutMovieView bindView(AboutMovieFragment fragment);

    @Binds
    abstract AboutMoviePresenter bindAboutMoviePresenter(AboutMoviePresenterImpl aboutMoviePresenterImpl);
}
