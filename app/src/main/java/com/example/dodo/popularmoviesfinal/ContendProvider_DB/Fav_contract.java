package com.example.dodo.popularmoviesfinal.ContendProvider_DB;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class Fav_contract {

    public static final String AUTHORITY = "com.example.android.moviedb";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    public static final String PATH_MOVIE = "movie";
    public static final String PATH_FAVORITES = "favorites";




    public static final class Favourite_entry implements BaseColumns {



        // table name

        public static final String TABLE_Fav = "Favourite";

       // columns

       public static final String COLUMN = "movie_id";


        // create content uri

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_Fav ).build();

        // for building URIs on insertion
        public static Uri buildFavorsUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);




    }
}}

//https://developer.android.com/training/data-storage/sqlite.html#java
//https://github.com/udacity/android-content-provider/blob/master/app/src/main/java/com/sam_chordas/android/androidflavors/data/FlavorsContract.java
//https://plus.google.com/u/0/events/clqsqgjs7n93hga5b9t1ddc78eg?authkey=COX1v_yspsWojwE

/**
 A contract class is a container for constants that define names for URIs, tables, and columns.
 The contract class allows you to use the same constants across all the other classes in the same package.
 This lets you change a column name in one place and have it propagate throughout your code.
 */