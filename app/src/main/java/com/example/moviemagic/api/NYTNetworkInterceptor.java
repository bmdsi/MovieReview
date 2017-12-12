package com.example.moviemagic.api;

import android.content.Context;


import com.example.moviemagic.R;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NYTNetworkInterceptor implements Interceptor {

    @Inject
    Context context;

    @Inject
    public NYTNetworkInterceptor() {
    }

    //Add the APPID query param to all the requests
    @Override
    public Response intercept(Chain chain) throws IOException {

        String apiKey = context.getString(R.string.api_key);

        Request original = chain.request();
        Request request = original
                .newBuilder()
                .header("api-key", apiKey)
                .build();

        return chain.proceed(request);
    }
}
