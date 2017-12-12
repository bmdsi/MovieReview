package com.example.moviemagic.ui.aboutmovie;

import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.example.moviemagic.R;
import com.example.moviemagic.core.PageNavigationControlledFragment;
import com.example.moviemagic.data.MovieData;
import com.example.moviemagic.ui.moviedetail.MovieDetailFragment;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Fragment displaying the details of the movie
 */

public class AboutMovieFragment extends PageNavigationControlledFragment implements AboutMovieView {

    static final String ARGS_MOVIE_DATA = "args_movie_data";

    @VisibleForTesting
    MovieData movieData;

    @BindView(R.id.movie_title)
    TextView movieTitle;

    @BindView(R.id.movie_image)
    ImageView imageView;

    @BindView(R.id.movie_headline)
    TextView movieHeadline;

    @BindView(R.id.movie_opening_date)
    TextView openingDate;

    @BindView(R.id.movie_summary)
    TextView movieSummary;

    @BindView(R.id.fav_animation_view)
    LottieAnimationView favAnimView;

    @Inject
    AboutMoviePresenter aboutMoviePresenter;

    /**
     * Get the instance of the Fragment
     * @param movieData the data that needs to be passed
     * @return fragment with data in the bundle
     */
    public static AboutMovieFragment newInstance(MovieData movieData) {
        Bundle args = new Bundle();
        //TODO do parcelable
        args.putSerializable(ARGS_MOVIE_DATA, movieData);
        AboutMovieFragment aboutMovieFragment = new AboutMovieFragment();
        aboutMovieFragment.setArguments(args);
        return aboutMovieFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        setHomeAsUp(true);
        setToolbarTitle(getString(R.string.about_movie_toolbar_title));
        movieData = (MovieData) getArguments().getSerializable(ARGS_MOVIE_DATA);
        favAnimView.setImageAssetsFolder("assets");

        favAnimView.setOnClickListener((view1) -> {
            if (!aboutMoviePresenter.isFav(movieData)) {
                favAnimView.playAnimation();
            } else {
                favAnimView.setProgress(0);
            }
            aboutMoviePresenter.onFavClicked(movieData);

        });

        if (aboutMoviePresenter.isFav(movieData)) {
            favAnimView.playAnimation();
        }
        return view;
    }

    @Override
    public void displayData(MovieData movieData) {
        movieTitle.setText(movieData.getDisplayTitle());
        movieHeadline.setText(movieData.getHeadline());
        openingDate.setText(movieData.getOpeningDate());
        movieSummary.setText(movieData.getShortSummary());
        Glide.with(this).load(movieData.getImageUrl())
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView);
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
    public void onStart() {
        super.onStart();
        aboutMoviePresenter.startPresenting();
        aboutMoviePresenter.startPresentingData(movieData);
    }

    @Override
    public void onStop() {
        aboutMoviePresenter.stopPresenting();
        super.onStop();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_about_movie;
    }
}
