package com.example.moviemagic.ui.topmovies;

import com.example.moviemagic.api.DataApi;
import com.example.moviemagic.data.ReviewResponse;
import com.example.moviemagic.injection.ActivityScope;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Implementation for @{@link TopMoviewInteractor}
 */

@ActivityScope
public class TopMoviewInteractorImpl implements TopMoviewInteractor {

    /**
     * Data api to fetch the data
     */
    DataApi dataApi;

    @Inject
    public TopMoviewInteractorImpl(DataApi dataApi) {
        this.dataApi = dataApi;
    }

    @Override
    public Single<ReviewResponse> getTopReviews(int offset) {
        //TODO we can do a merge operation if we need to get the data from cache
        return dataApi.getTopReviews(offset).subscribeOn(Schedulers.io())
                .doAfterSuccess(reviewResponse -> loadDataToCache(reviewResponse));

    }

    private void loadDataToCache(ReviewResponse response) {
        //TODO store the value in cache
    }
}
