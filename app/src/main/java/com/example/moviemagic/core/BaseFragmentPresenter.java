package com.example.moviemagic.core;

/**
 * Base Presenter interface (MVP) to be implemented by Presenters that will work with Fragments as their View.
 */
public interface BaseFragmentPresenter {

    /**
     * Tell the presenter that it's OK to start calling methods on the View at this point.  Should be called from the
     * Fragment where its ideal to start.
     */
    void startPresenting();

    /**
     * Tell the presenter that it's no longer safe to call methods on the View at this point.
     */
    void stopPresenting();

}
