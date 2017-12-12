package com.example.moviemagic.ui.topmovies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.moviemagic.R;
import com.example.moviemagic.core.PageNavigationControlledFragment;
import com.example.moviemagic.data.MovieData;
import com.example.moviemagic.ui.moviedetail.MovieDetailFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Fragment showing the list of top movies
 */

public class TopMoviesFragment extends PageNavigationControlledFragment implements TopMoviesView, MoviesAdapter.OnInstanceSelectedListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    /**
     * Creates a new instance of the @{@link TopMoviesFragment}
     *
     * @return TopMoviesFragment
     */
    public static TopMoviesFragment newInstance() {
        return new TopMoviesFragment();
    }

    @Inject
    TopMoviesPresenter topMoviesPresenter;

    @VisibleForTesting
    MoviesAdapter moviesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        swipeRefreshLayout.setEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        moviesAdapter = new MoviesAdapter(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation()));
        recyclerView.setAdapter(moviesAdapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolbarTitle(getString(R.string.top_movie_toolbar_title));
        setHomeAsUp(false);
    }

    @Override
    public void onStart() {
        super.onStart();
        topMoviesPresenter.startPresenting();
    }

    @Override
    public void onStop() {
        topMoviesPresenter.stopPresenting();
        super.onStop();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_top_movies;
    }

    @Override
    public void showLoadingIndicator() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoadingIndicator() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void displayTopMovies(List<MovieData> movies) {
        moviesAdapter.setData(movies);
    }

    @Override
    public void showErrorLoadingMovie() {
        Toast.makeText(getActivity(), "Loading error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(MovieData movieData) {
        Toast.makeText(getActivity(), movieData.getDisplayTitle(), Toast.LENGTH_LONG).show();
        pageNavigationController.displayChildFragment(MovieDetailFragment.newInstance(movieData));

    }
}
