package com.example.moviemagic.ui.favourite;

import com.example.moviemagic.api.UserDataSource;
import com.example.moviemagic.core.SharedPreferencesUtil;
import com.example.moviemagic.data.MovieData;
import com.example.moviemagic.injection.ActivityScope;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Implementation for @{@link FavouritePresenter}
 */

@ActivityScope
public class FavouritePresenterImpl implements FavouritePresenter {

    FavouriteView view;
    UserDataSource userDataSource;
    SharedPreferencesUtil sharedPreferencesUtil;

    @Inject
    public FavouritePresenterImpl(FavouriteView view
            , SharedPreferencesUtil sharedPreferencesUtil, UserDataSource userDataSource) {
        this.view = view;
        this.sharedPreferencesUtil = sharedPreferencesUtil;
        this.userDataSource = userDataSource;
    }

    @Override
    public void startPresenting() {
        //List<String> favs = sharedPreferencesUtil.geFavMovies();
        userDataSource.getFavMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(favList -> {
            view.showFavs(favList);
        }, throwable -> {
            //TODO show error
        });

    }

    @Override
    public void stopPresenting() {

    }
}
