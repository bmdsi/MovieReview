package com.example.moviemagic.core;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Interface that allow child fragments displayed in the MainActivity's content view to push sub pages onto the stack.
 */
public interface PageNavigationController {

    /**
     * Display the provided {@link Fragment} as a child view.  The previously shown fragment will be in the "back stack"
     * with the provided fragment now at the top of the stack.
     *
     * @param fragment - The fragment to display.
     */
    void displayChildFragment(Fragment fragment);

    /**
     * Display the provided {@link Fragment} as a child view.  The previously shown fragment will be in the "back stack"
     * with the provided fragment now at the top of the stack.
     *
     * @param fragment                - The fragment to display.
     * @param sharedElementParentView - The view in the parent fragment that will transition to the shared element in
     *                                the child fragment.
     */
    void displayChildFragmentWithTransition(Fragment fragment, View sharedElementParentView);

    /**
     * Display the provided {@link Fragment} as the root view of an empty stack.  That is, any prior back-stack of
     * fragments will be cleared before this fragment is displayed.
     *
     * @param fragment - The Fragment to display.
     */
    void displayRootFragment(Fragment fragment);

    /**
     * Call-through to {@link android.support.v7.app.AppCompatActivity#onBackPressed()}.
     */
    void onBackPressed();

}
