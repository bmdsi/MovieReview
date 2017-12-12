package com.example.moviemagic.ui.favourite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviemagic.R;
import com.example.moviemagic.core.PageNavigationControlledFragment;
import com.example.moviemagic.data.MovieData;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Fragment that displays users fav movie list
 */

public class FavouriteFragment extends PageNavigationControlledFragment
        implements FavouriteView, FavMoviesAdapter.OnInstanceSelectedListener {

    @VisibleForTesting
    FavMoviesAdapter favMoviesAdapter;

    @Inject
    FavouritePresenter favouritePresenter;

    @BindView(R.id.fav_recyclerView)
    RecyclerView favRecyclerView;

    /**
     * Creates an new instance of the fragment
     *
     * @return FavouriteFragment
     */
    public static FavouriteFragment newInstance() {
        return new FavouriteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        favRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        favMoviesAdapter = new FavMoviesAdapter(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        favRecyclerView.addItemDecoration(new DividerItemDecoration(favRecyclerView.getContext(), layoutManager.getOrientation()));
        favRecyclerView.setAdapter(favMoviesAdapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHomeAsUp(false);
        setToolbarTitle(getString(R.string.fav_movie_toobar_title));
        favouritePresenter.startPresenting();
    }


    @Override
    public void onStop() {
        favouritePresenter.stopPresenting();
        super.onStop();
    }

    /*@Override
    public void showFavs(List<String> favs) {
        favMoviesAdapter.setData(favs);
    }*/

    @Override
    public void showFavs(List<MovieData> favs) {
        favMoviesAdapter.setData(favs);
    }

    @Override
    public void showLoadingIndicator() {
        //TODO
    }

    @Override
    public void hideLoadingIndicator() {
        //TODO
    }

    @Override
    public void onItemSelected(MovieData movieData) {
        //TODO : We can take the user back to the detail view.
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_favourite;
    }
}
