package com.example.moviemagic.ui.topmovies;

import dagger.Binds;
import dagger.Module;

/**
 * Dagger dependencies binding
 */

@Module
public abstract class TopMoviesModule {
    @Binds
    abstract TopMoviesView bindView(TopMoviesFragment fragment);

    @Binds
    abstract TopMoviesPresenter bindTopMoviesPresenter(TopMoviePresenterImpl topMoviePresenter);

    @Binds
    abstract TopMoviewInteractor bindTopMoviewInteractor(TopMoviewInteractorImpl topMoviewInteractor);

}
