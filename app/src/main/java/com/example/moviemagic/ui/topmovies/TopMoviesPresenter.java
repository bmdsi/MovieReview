package com.example.moviemagic.ui.topmovies;

import android.support.annotation.VisibleForTesting;

import com.example.moviemagic.core.BaseFragmentPresenter;
import com.example.moviemagic.data.MovieData;

/**
 * Presenter for the @{@link TopMoviesFragment} view (MVP pattern)
 */

public interface TopMoviesPresenter extends BaseFragmentPresenter {

    /**
     * load the top movies from the network
     */
    void loadTopMovies();


}
