package com.example.moviemagic.ui.topmovies;

import com.example.moviemagic.core.BaseContentView;
import com.example.moviemagic.data.MovieData;

import java.util.List;

/**
 * View interface for the @{@link TopMoviesFragment} MVP pattern
 */

public interface TopMoviesView extends BaseContentView {

    /**
     * Display the list of movies in the listview
     *
     * @param movies
     */
    void displayTopMovies(List<MovieData> movies);

    /**
     * Show errorview in case of any errors while fetching data
     */
    void showErrorLoadingMovie();
}
