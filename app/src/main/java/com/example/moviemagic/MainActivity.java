package com.example.moviemagic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.moviemagic.api.DataApi;
import com.example.moviemagic.core.PageNavigationController;
import com.example.moviemagic.ui.favourite.FavouriteFragment;
import com.example.moviemagic.ui.topmovies.TopMoviesFragment;

import javax.inject.Inject;

/**
 * Activity that holds the botton navigation bar
 * //TODO convert to MVP (For now, left it for the sake of simpilicity
 */
public class MainActivity extends BaseActivity implements PageNavigationController {

    @Inject
    DataApi dataApi;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    displayRootFragment(TopMoviesFragment.newInstance());
                    return true;
                case R.id.navigation_search:
                    Toast.makeText(MainActivity.this , "Search coming soon", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.navigation_favourite:
                    displayRootFragment(FavouriteFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void displayChildFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void displayChildFragmentWithTransition(Fragment fragment, View sharedElementParentView) {
        //TODO
    }

    @Override
    public void displayRootFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Pop all back stack to start fresh
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

}
