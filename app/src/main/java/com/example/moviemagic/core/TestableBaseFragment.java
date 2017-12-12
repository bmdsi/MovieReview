package com.example.moviemagic.core;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * The ultimate base Fragment class to subclass for Riot.  Enables us to test fragments without using Robolectric for
 * most things by stubbing the super calls for various lifecycle methods.
 */
public abstract class TestableBaseFragment extends Fragment {

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        proxySuperOnCreate(savedInstanceState);
    }

    @VisibleForTesting
    @Untested("Allows us to mock the super call to onCreate() so we can test without Robolectric")
    public void proxySuperOnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return proxySuperOnCreateView(inflater, container, savedInstanceState);
    }

    @VisibleForTesting
    @Untested("Allows us to mock the super call to onCreateView() so we can test without Robolectric")
    public View proxySuperOnCreateView(@NonNull LayoutInflater inflater,
                                       @Nullable ViewGroup container,
                                       @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @VisibleForTesting
    @Untested("Allows us to stub out the actual inflation of the view for testing.")
    public View inflateView(LayoutInflater inflater,
                            ViewGroup container,
                            int layoutId) {
        return inflater.inflate(layoutId, container, false);
    }

    @VisibleForTesting
    @Untested("Allows us to stab out the actual binding of views for testing purposes.")
    public Unbinder bindViews(View rootView) {
        return ButterKnife.bind(this, rootView);
    }

}
