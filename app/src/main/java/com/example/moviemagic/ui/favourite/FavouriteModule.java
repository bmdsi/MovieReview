package com.example.moviemagic.ui.favourite;

import dagger.Binds;
import dagger.Module;

/**
 * Dagger dependencies
 */

@Module
public abstract class FavouriteModule {

    @Binds
    abstract FavouriteView bindView(FavouriteFragment fragment);

    @Binds
    abstract FavouritePresenter bindAboutMoviePresenter(FavouritePresenterImpl favouritePresenterImpl);
}
