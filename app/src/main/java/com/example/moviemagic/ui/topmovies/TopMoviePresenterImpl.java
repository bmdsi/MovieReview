package com.example.moviemagic.ui.topmovies;

import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.example.moviemagic.injection.ActivityScope;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Presenter implementation for @{@link TopMoviesPresenter}
 */

@ActivityScope
public class TopMoviePresenterImpl implements TopMoviesPresenter {

    //Injected
    TopMoviesView topMoviesView;
    TopMoviewInteractor topMoviewInteractor;

    /**
     * to hold on to the subscription and cleaned when done
     */
    @VisibleForTesting
    CompositeDisposable disposables;

    /**
     * @param topMoviesView
     * @param topMoviewInteractor
     */
    @Inject
    public TopMoviePresenterImpl(TopMoviesView topMoviesView, TopMoviewInteractor topMoviewInteractor) {
        this.topMoviesView = topMoviesView;
        this.topMoviewInteractor = topMoviewInteractor;
    }

    @Override
    public void loadTopMovies() {
        disposables.add(topMoviewInteractor.getTopReviews(20)
                .doOnSubscribe(__ -> topMoviesView.showLoadingIndicator())
                .doAfterTerminate(() -> topMoviesView.hideLoadingIndicator())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(reviewResponse -> {
                    topMoviesView.displayTopMovies(reviewResponse.getResults());
                }, throwable -> {
                    topMoviesView.showErrorLoadingMovie();
                }));
    }


    @Override
    public void startPresenting() {
        disposables = new CompositeDisposable();
        loadTopMovies();
    }

    @Override
    public void stopPresenting() {
        if (disposables != null && !disposables.isDisposed()) {
            disposables.dispose();
        }
    }

}
