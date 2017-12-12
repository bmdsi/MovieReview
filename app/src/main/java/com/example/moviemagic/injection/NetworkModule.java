package com.example.moviemagic.injection;

import android.content.Context;

import com.example.moviemagic.R;
import com.example.moviemagic.api.DataApi;
import com.example.moviemagic.api.NYTNetworkInterceptor;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    static OkHttpClient provideHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                   NYTNetworkInterceptor nytNetworkInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(nytNetworkInterceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    static GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create(new GsonBuilder().create());
    }

    @Provides
    @Singleton
    static DataApi provideDataApi(Context context,
                                  OkHttpClient httpClient,
                                  GsonConverterFactory gsonConverterFactory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.nyt_base_url))
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(DataApi.class);
    }


}
