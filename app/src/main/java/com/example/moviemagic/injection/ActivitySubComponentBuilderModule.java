package com.example.moviemagic.injection;

import com.example.moviemagic.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Dependency module for activity
 */

@Module
public abstract class ActivitySubComponentBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}
