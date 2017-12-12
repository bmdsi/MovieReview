package com.example.moviemagic.ui.aboutmovie;

import com.example.moviemagic.core.BaseContentView;
import com.example.moviemagic.data.MovieData;

/**
 * View class
 */

public interface AboutMovieView extends BaseContentView {

    /**
     * Display the data in the view
     * @param movieData
     */
    void displayData(MovieData movieData);
}
