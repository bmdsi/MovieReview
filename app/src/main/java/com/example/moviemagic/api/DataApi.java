package com.example.moviemagic.api;

import com.example.moviemagic.data.ReviewResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * API calls to the server
 */

public interface DataApi {

    /**
     * Get all the top reviews
     * @param offset the paginated number in multiples of 20
     * @return all the reviews
     */
    @GET("reviews/all.json")
    Single<ReviewResponse> getTopReviews(@Query("offset") int offset);
}
