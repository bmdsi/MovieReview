package com.example.moviemagic.ui.moviedetail;

import com.example.moviemagic.core.BaseContentView;
import com.example.moviemagic.data.MovieData;

/**
 * Created by kumar on 12/10/17.
 */

public interface MovieDetailView extends BaseContentView {

    void showMovieDetail(MovieData movieData);
}
