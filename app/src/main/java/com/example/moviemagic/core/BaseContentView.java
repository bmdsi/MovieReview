package com.example.moviemagic.core;

/**
 * interface for views that needs to show loading
 */

public interface BaseContentView {

    /**
     * Show a progress bar on the view indicating to the user that the data for this page is loading.
     */
    void showLoadingIndicator();

    /**
     * Hide the progress bar on the view.
     */
    void hideLoadingIndicator();
}
