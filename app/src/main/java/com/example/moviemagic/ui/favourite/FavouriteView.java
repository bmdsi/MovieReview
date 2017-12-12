package com.example.moviemagic.ui.favourite;

import com.example.moviemagic.core.BaseContentView;
import com.example.moviemagic.data.MovieData;

import java.util.List;

/**
 * Created by kumar on 12/11/17.
 */

public interface FavouriteView extends BaseContentView {
    //void showFavs(List<String> favs);
    void showFavs(List<MovieData> favs);
}
