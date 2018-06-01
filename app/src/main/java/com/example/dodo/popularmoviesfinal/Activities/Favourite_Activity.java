package com.example.dodo.popularmoviesfinal.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dodo.popularmoviesfinal.R;

public class Favourite_Activity extends AppCompatActivity  {

        public static final String LOG_TAG =Favourite_Activity.class.getSimpleName();
    public static final int LOADER_ID = 0;

     android.support.v7.widget.RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_2);

/*










    private FavouritesMoviesAdapter favouriteMoviesAdapter;
    private LinearLayoutManager linearLayoutManager;

    //cursor to hold the data queryied from the database
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Favourite Movies");
        recyclerView = (RecyclerView) findViewById(R.id.favorites_recycler_view); //gert reference to the recycler view
      MoviesAdapter = new MoviesAdapter(this); //instantiate the adadpter
        linearLayoutManager = new GridLayoutManager(getApplicationContext(), 2); //instantiate the layout manager
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(favouriteMoviesAdapter);

        getSupportLoaderManager().initLoader(LOADER_ID, null, this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().restartLoader(LOADER_ID, null, this);
    }



    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<Cursor>(this) {
            // Initialize a Cursor, this will hold all the task data

            // onStartLoading() is called when a loader first starts loading data
            @Override
            protected void onStartLoading() {
                if (cursor != null) {
                    // Delivers any previously loaded data immediately
                    deliverResult(cursor);
                } else {
                    // Force a new load
                    forceLoad();
                }
            }

            // loadInBackground() performs asynchronous loading of data
            @Override
            public Cursor loadInBackground() {
                // Will implement to load data
                Cursor cursor;

                try {
                    cursor = getContentResolver().query(MovieContract.Favorites.CONTENT_URI,
                            null,
                            null,
                            null,
                            null);
                    return cursor;

                } catch (Exception e) {
                    Log.e(LOG_TAG, "Failed to asynchronously load data.");
                    e.printStackTrace();
                    return null;
                }



            }

            // deliverResult sends the result of the load, a Cursor, to the registered listener
            public void deliverResult(Cursor data) {
                cursor = data;
                //favouriteMoviesAdapter.getFavouriteMoviesDataFromCursor(cursor);
                super.deliverResult(data);
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        favouriteMoviesAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        favouriteMoviesAdapter.swapCursor(null);
    }
}























  https://discussions.udacity.com/t/multiple-loaders-in-the-same-fragment/561971/12









  Even, to request for the trailers and reviews, first we’ll need to get the movie ID. This means that when selecting a movie from the “Favorites” list, we would need the movie ID from the JSON to build the URLs to get the trailers and reviews.
 */
    }







//https://stackoverflow.com/questions/41762497/one-recycleradapter-for-two-activity

//https://www.sitepoint.com/mastering-complex-lists-with-the-android-recyclerview



//https://github.com/AndroidDevScholarship/Android-Project-from-Scratch-Guide#asynctaskloaderd


    }

