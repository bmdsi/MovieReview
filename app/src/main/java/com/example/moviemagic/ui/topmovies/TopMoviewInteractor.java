package com.example.moviemagic.ui.topmovies;

import com.example.moviemagic.data.ReviewResponse;

import io.reactivex.Single;

/**
 * Interactor to fetch the top movies.
 */

public interface TopMoviewInteractor {
    /**
     * Get the top reviews for the offset
     *
     * @param offset pagination in multiples of 20
     * @return
     */
    Single<ReviewResponse> getTopReviews(int offset);
}
