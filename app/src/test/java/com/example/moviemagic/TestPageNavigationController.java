package com.example.moviemagic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.moviemagic.core.PageNavigationController;

/**
 * Concrete {@link PageNavigationController} class with which to test.
 */
public class TestPageNavigationController extends AppCompatActivity
        implements PageNavigationController {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //Avoid IllegalStateException when using this class to start PageNavigationControlledFragment's.
        super.onCreate(savedInstanceState);
    }

    @Override
    public void displayChildFragment(Fragment fragment) {
        //NO-OP, for testing
    }

    @Override
    public void displayChildFragmentWithTransition(Fragment fragment, View sharedElementParentView) {
        //NO-OP, for testing
    }

    @Override
    public void displayRootFragment(Fragment fragment) {
        //NO-OP, for testing
    }

}
