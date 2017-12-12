package com.example.moviemagic.core;

import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import javax.inject.Inject;

import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Base fragment used to share functionality common to all fragments within application.
 */
public abstract class BaseContentFragment extends TestableBaseFragment {


    @VisibleForTesting
    Unbinder unbinder;
    @VisibleForTesting
    View rootView;

    /**
     * Sets up dagger for fragment.
     */
    @VisibleForTesting
    public void injectDaggerMembers() {
        AndroidSupportInjection.inject(this);
    }

    /**
     * Gets the view ID that should inflated in onCreateView.
     *
     * @return the resId of the layout that is to be inflated.
     */
    public abstract int getLayoutId();

    @Override
    public void onAttach(Context context) {
        injectDaggerMembers();
        super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Same as onCreateView but takes id to inflate and activates butterknife.
     *
     * @param inflater           -
     * @param container          -
     * @param savedInstanceState -
     * @return root view that was inflated
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        rootView = inflateView(inflater, container, getLayoutId());
        unbinder = bindViews(rootView);
        return rootView;
    }
}
