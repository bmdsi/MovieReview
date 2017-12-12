package com.example.moviemagic.core;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.view.MenuItem;


/**
 * {@link BaseContentFragment} that is hosted by a {@link PageNavigationController}.
 */
public abstract class PageNavigationControlledFragment extends ToolbarHostControlledFragment {

    //Public because we need to access this for testing subclass implementations.
    @VisibleForTesting
    public PageNavigationController pageNavigationController;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        //Required so that the Activity delegates onOptionItemSelected to the fragment
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        attachPageNavigationController(context);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            pageNavigationController.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Public method so that in tests we can override this to do nothing and maintain a mock instance of
     * the PageNavigationController.
     * @param context -
     */
    @VisibleForTesting
    public void attachPageNavigationController(Context context) {
        if (context instanceof PageNavigationController) {
            this.pageNavigationController = (PageNavigationController) context;
        } else {
            throw new IllegalStateException("Activity hosting " + getClass().getSimpleName() + " must implement "
                    + "PageNavigationController!");
        }
    }

}
