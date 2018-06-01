package com.example.dodo.popularmoviesfinal.ContendProvider_DB;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;

import java.util.Objects;

public class MyContentProvider extends ContentProvider {
    private Fav_DB_Helper  mOpenHelper;
    //global variable
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    public static final int Movies = 200;

    private static final int FAVOR = 100;

    private static final int FAVOR_WITH_ID = 101;


    // Codes for the UriMatcher //////


    private static UriMatcher buildUriMatcher() {
        // Build a UriMatcher by adding a specific code to return based on a match
        // It's common to use NO_MATCH as the code for this case.
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String  authority= Fav_contract.AUTHORITY ;
        // add a code for each type of URI you want
        matcher.addURI(authority,Fav_contract.PATH_MOVIE,  FAVOR );
        matcher.addURI(authority, Fav_contract.PATH_FAVORITES, Movies);
        //matcher for one favourite in the database
        matcher.addURI(authority, Fav_contract.Favourite_entry.TABLE_Fav + "/#", FAVOR_WITH_ID);

        return matcher;

    }


    public MyContentProvider() {
    }




    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(@NonNull Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();


        Uri returnUri;
        switch (sUriMatcher.match(uri)) {
            case FAVOR: {
                //inserting values into tables
                long _id = db.insert(Fav_contract.Favourite_entry.TABLE_Fav, null, values);
                // insert unless it is already contained in the database
                if (_id > 0) {
                    //success                         //new row id
                    returnUri = Fav_contract.Favourite_entry.buildFavorsUri(_id);
                } else {
                    throw new SQLException("Failed to insert row into: " + uri);
                }
                break;
            }

            default: {
                throw new UnsupportedOperationException("Unknown uri: " + uri);

            }
        }
        //notify reolver that smth has chnaged:

        Objects.requireNonNull(getContext()).getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.

        mOpenHelper  = new Fav_DB_Helper(getContext());
        return true;

    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        Cursor retCursor;
        switch (sUriMatcher.match(uri)) {
            // All Flavors selected
            case FAVOR : {
                retCursor = mOpenHelper.getReadableDatabase().query(
                        Fav_contract.Favourite_entry.TABLE_Fav,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);


                return retCursor;
            }
            // Individual favorite based on Id selected
            case FAVOR_WITH_ID : {
                retCursor = mOpenHelper.getReadableDatabase().query(
                        Fav_contract.Favourite_entry.TABLE_Fav,                        projection,
                        Fav_contract.Favourite_entry._ID + " = ?",
                        new String[]{String.valueOf(ContentUris.parseId(uri))},
                        null,
                        null,
                        sortOrder);



                return retCursor;
            }
            default: throw new UnsupportedOperationException("Unknown uri: " + uri);


            }

// notification uri on cursor


        // TODO: Implement this to handle query requests from clients.
    }





    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}


/*


 https://github.com/udacity/ud851-Exercises/blob/student/Lesson09-ToDo-List/T09.05-Solution-QueryAllTasks/app/src/main/java/com/example/android/todolist/AddTaskActivity.java
  Even, to request for the trailers and reviews, first we’ll need to get the movie ID.
  This means that when selecting a movie from the “Favorites” list,
  we would need the movie ID from the JSON to build the URLs to get the trailers and reviews.

 https://developer.android.com/guide/topics/providers/content-provider-basics.html
 http://www.vogella.com/tutorials/AndroidSQLite/article.html
 */


