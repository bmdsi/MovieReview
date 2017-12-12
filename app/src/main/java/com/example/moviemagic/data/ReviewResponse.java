package com.example.moviemagic.data;

import java.util.List;

/**
 * Response class for reviews
 */

public class ReviewResponse {

    List<MovieData> results;

    public void setResults(List<MovieData> results) {
        this.results = results;
    }

    public List<MovieData> getResults() {
        return results;
    }
}
