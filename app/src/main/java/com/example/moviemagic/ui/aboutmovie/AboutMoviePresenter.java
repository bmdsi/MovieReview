package com.example.moviemagic.ui.aboutmovie;

import com.example.moviemagic.core.BaseFragmentPresenter;
import com.example.moviemagic.data.MovieData;

import io.reactivex.Observable;

/**
 * Presenter class
 */

public interface AboutMoviePresenter extends BaseFragmentPresenter {

    /**
     * View can be updated with the data
     * @param movieData
     */
    void startPresentingData(MovieData movieData);

    /**
     * callback for the fav icon click
     * @param movieData
     */
    void onFavClicked(MovieData movieData);

    /**
     * Check to see if movie is already in the fav list
     * @param movieData
     * @return
     */
    boolean isFav(MovieData movieData);
}
