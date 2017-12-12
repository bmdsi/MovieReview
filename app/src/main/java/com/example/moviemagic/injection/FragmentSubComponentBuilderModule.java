package com.example.moviemagic.injection;

import com.example.moviemagic.MovieWebViewFragment;
import com.example.moviemagic.ui.aboutmovie.AboutMovieFragment;
import com.example.moviemagic.ui.aboutmovie.AboutMovieModule;
import com.example.moviemagic.ui.favourite.FavouriteFragment;
import com.example.moviemagic.ui.favourite.FavouriteModule;
import com.example.moviemagic.ui.moviedetail.MovieDetailFragment;
import com.example.moviemagic.ui.moviedetail.MovieDetailModule;
import com.example.moviemagic.ui.topmovies.TopMoviesFragment;
import com.example.moviemagic.ui.topmovies.TopMoviesModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by kumar on 12/9/17.
 */

@Module
public abstract class FragmentSubComponentBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = TopMoviesModule.class)
    abstract TopMoviesFragment topMoviesFragment();

    @ActivityScope
    @ContributesAndroidInjector(modules = MovieDetailModule.class)
    abstract MovieDetailFragment movieDetailFragment();

    @ActivityScope
    @ContributesAndroidInjector
    abstract MovieWebViewFragment movieWebViewFragment();

    @ActivityScope
    @ContributesAndroidInjector(modules = AboutMovieModule.class)
    abstract AboutMovieFragment aboutMovieFragment();

    @ActivityScope
    @ContributesAndroidInjector(modules = FavouriteModule.class)
    abstract FavouriteFragment favouriteFragment();


}
