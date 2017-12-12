package com.example.moviemagic.core;

import android.support.v7.app.ActionBar;

import com.example.moviemagic.BaseActivity;

/**
 * Fragment with util methods on setting attributes to the toolbar
 */
public abstract class ToolbarHostControlledFragment extends BaseContentFragment {


    /**
     * Convenience method for setting the toolbar title.
     *
     * @param title The string to set the
     */
    public void setToolbarTitle(CharSequence title) {
        final ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null && title != null) {
            actionBar.setTitle(title);
        }
    }


    /**
     * Sets setDisplayHomeAsUpEnabled on the toolbar.
     *
     * @param homeAsUp True if the backarrow should be displayed, False to hide the back arrow.
     */
    public void setHomeAsUp(boolean homeAsUp) {
        final ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(homeAsUp);
        }
    }
}
