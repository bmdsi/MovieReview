package com.example.moviemagic.ui.moviedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviemagic.R;
import com.example.moviemagic.core.PageNavigationControlledFragment;
import com.example.moviemagic.data.MovieData;

import butterknife.BindView;

/**
 * Created by kumar on 12/10/17.
 */

public class MovieDetailFragment extends PageNavigationControlledFragment implements MovieDetailView {

    @VisibleForTesting
    public static final String ARGS_MOVIE_DATA = "args_movie_data";

    @VisibleForTesting
    MovieData movieData;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @VisibleForTesting
    MovieDetailFragmentPagerAdapter movieDetailFragmentPagerAdapter;

    public static final MovieDetailFragment newInstance(MovieData movieData) {
        Bundle args = new Bundle();
        //TODO do parcelable
        args.putSerializable(ARGS_MOVIE_DATA, movieData);
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ViewCompat.setElevation(tabLayout,
                getResources().getDimensionPixelSize(R.dimen.tab_layout_elevation));
        setHomeAsUp(true);
        movieData = (MovieData) getArguments().getSerializable(ARGS_MOVIE_DATA);
        return view;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_movie_detail;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpTabs();
    }

    @VisibleForTesting
    void setUpTabs() {
        movieDetailFragmentPagerAdapter = new MovieDetailFragmentPagerAdapter(getChildFragmentManager(), movieData);
        viewPager.setAdapter(movieDetailFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(getContext(), R.color.white));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getContext(), R.color.white));
        tabLayout.setBackgroundColor(getContext().getResources().getColor(R.color.grey));
    }

    @Override
    public void showMovieDetail(MovieData movieData) {
        //TODO
    }

    @Override
    public void showLoadingIndicator() {
        //TODO
    }

    @Override
    public void hideLoadingIndicator() {
        //TODO
    }
}
