package com.example.moviemagic.injection;


import com.example.moviemagic.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class, AppModule.class, LoggingModule.class, NetworkModule.class
        , ActivitySubComponentBuilderModule.class, FragmentSubComponentBuilderModule.class})
public interface AppComponent extends AndroidInjector<App> {
    void inject(App app);


}