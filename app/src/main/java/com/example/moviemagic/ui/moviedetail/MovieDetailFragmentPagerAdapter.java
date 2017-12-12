package com.example.moviemagic.ui.moviedetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.moviemagic.MovieWebViewFragment;
import com.example.moviemagic.data.MovieData;
import com.example.moviemagic.ui.aboutmovie.AboutMovieFragment;

/**
 * Created by kumar on 12/10/17.
 */

public class MovieDetailFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_TABS = 2;
    private final String[] pageTitles;
    private MovieData movieData;

    public MovieDetailFragmentPagerAdapter(FragmentManager fragmentManager, MovieData movieData) {
        super(fragmentManager);
        this.movieData = movieData;
        this.pageTitles = new String[]{"detail", "article"}; //TODO set proper title
    }

    @Override
    public Fragment getItem(int position) {
        return position == 0 ? AboutMovieFragment.newInstance(movieData) : MovieWebViewFragment.newInstance(movieData);
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }
}
