package com.example.moviemagic.injection;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.moviemagic.R;
import com.example.moviemagic.api.UserDataSource;
import com.example.moviemagic.api.dao.UserDataSourceImpl;
import com.example.moviemagic.api.dao.UserDatabase;
import com.example.moviemagic.core.SharedPreferencesUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Application module that provides dependencies for singletons
 */
@Module
public class AppModule {
    Application application;
    private static final String SHARED_PREFS_NAME = "DefaultSharedPrefs";

    public AppModule(Application application) {
        this.application = application;
    }


    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences providesSharedPreferences() {
        return application.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public SharedPreferencesUtil providesSharedPreferencesUtil(SharedPreferences sharedPrefs) {
        return new SharedPreferencesUtil(sharedPrefs);
    }

    @Provides
    @Singleton
    UserDataSource provideUserDataSource(Context context) {
        UserDatabase database = UserDatabase.getInstance(context);
        String databaseName = context.getString(R.string.database_name);
        return new UserDataSourceImpl(database.getCityDao(), databaseName);
    }
}
