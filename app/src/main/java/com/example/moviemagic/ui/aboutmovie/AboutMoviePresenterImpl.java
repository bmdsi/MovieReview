package com.example.moviemagic.ui.aboutmovie;

import com.example.moviemagic.api.UserDataSource;
import com.example.moviemagic.core.SharedPreferencesUtil;
import com.example.moviemagic.data.MovieData;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Implementation for @{@link AboutMoviePresenter}
 */

public class AboutMoviePresenterImpl implements AboutMoviePresenter {

    AboutMovieView view;
    SharedPreferencesUtil sharedPreferencesUtil;
    UserDataSource userDataSource;
    CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public AboutMoviePresenterImpl(AboutMovieView aboutMovieView
            , SharedPreferencesUtil sharedPreferencesUtil, UserDataSource userDataSource) {
        this.view = aboutMovieView;
        this.sharedPreferencesUtil = sharedPreferencesUtil;
        this.userDataSource = userDataSource;
    }

    @Override
    public void startPresenting() {
        view.showLoadingIndicator();
    }

    @Override
    public void startPresentingData(MovieData movieData) {
        //We can do any formatting that we might want to do with the data
        view.displayData(movieData);
    }

    @Override
    public void onFavClicked(MovieData movieData) {
        if (isFav(movieData)) {
            userDataSource.deleteMovie(movieData);
        } else {
            userDataSource.insertMovie(movieData);
        }
    }


    @Override
    public boolean isFav(MovieData movieData) {
        //return sharedPreferencesUtil.isFav(movieData.getDisplayTitle());
        MovieData movieData1 = userDataSource.getFavByTitle(movieData.getDisplayTitle());
        if (movieData1 != null) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void stopPresenting() {

    }
}
