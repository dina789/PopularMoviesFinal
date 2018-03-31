package com.example.dodo.popularmoviesfinal.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dodo on 3/31/2018.
 */

public class Api {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }




}
/*
https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit
https://stackoverflow.com/questions/40012341/how-to-define-api-endpoint-for-retrofit
https://futurestud.io/tutorials/retrofit-optional-query-parameters
https://inthecheesefactory.com/blog/retrofit-2.0/en
https://www.androidhive.info/2016/05/android-working-with-retrofit-http-library/
https://www.androidhive.info/2016/05/android-working-with-retrofit-http-library/
 */