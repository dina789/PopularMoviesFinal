package com.example.dodo.popularmoviesfinal;

import android.app.LoaderManager;
import android.database.Cursor;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;

import com.example.dodo.popularmoviesfinal.Adapters.MoviesAdapter;
import com.example.dodo.popularmoviesfinal.Models.MoviesData;
import com.example.dodo.popularmoviesfinal.Network.Api;
import com.example.dodo.popularmoviesfinal.Network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



//Notes:
/**The correct would be create a object that contains a list of movies.
 *  Then, you can create the API interface returns that responde object. */

public class MainActivity extends AppCompatActivity implements

       MoviesAdapter.MoviesAdapterOnClickHandler {

    private List<MoviesData> MovieList= new ArrayList<>();
    private final static String API_KEY = "90cfeb2390166bcd501adabe6f68e59a";

  //  private SwipeRefreshLayout swipeRefreshLayout;

    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Add a toolbar:
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);





        // Initialize recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);



        MoviesAdapter  moviesAdapter = new MoviesAdapter(this, this);

        /* Setting the adapter attaches it to the RecyclerView in our layout. */
        recyclerView.setAdapter( moviesAdapter);


// grid layout manager
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

        recyclerView.setHasFixedSize(true);




//failed to implement swiperefresh:(
        //swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
      //  swipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
 /*
     * Using findViewById, we get a reference to our RecyclerView from xml. This allows us to
         * do things like set the adapter of the RecyclerView and toggle the visibility.
         */



        ApiInterface apiService =
                Api.getClient().create(ApiInterface.class);

        Call<MoviesData> call = apiService.getMovieList(API_KEY);
        call.enqueue(new Callback<MoviesData>() {

            public void onResponse(Call<MoviesData> call, Response<MoviesData> response) {
                @Override
                  int statusCode = response.code();
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MoviesData> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting_menu, menu);
        //set menu item title based on sort key





        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public void onClick(long date) {

    }
}














/*


to implement and check:
https://classroom.udacity.com/nanodegrees/nd801/parts/9bb83157-0407-47dc-b0c4-c3d4d7dc66df/modules/418d7086-8596-4c73-8d1b-8bddef80c116/lessons/c81cb722-d20a-495a-83c6-6890a6142aac/concepts/3da2dca7-50a2-413b-958c-987080988ae1

for swiperefresh

> SwipeRefreshLayout:
In order to refresh the inbox, SwipeRefreshLayout is wrapped around the RecyclerView.
This article doesn’t explains the persistence of the data.
So the inbox will be reset to initial state up on refresh.



https://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
for setting and menu:

https://google-developer-training.gitbooks.io/android-developer-fundamentals-course-practicals/content/en/Unit%204/92_p_adding_settings_to_an_app.html
https://google-developer-training.gitbooks.io/android-developer-fundamentals-course-practicals/content/en/Unit%202/42_p_use_an_options_menu_and_radio_buttons.htmlhttps://developer.android.com/guide/topics/ui/menus.html#groups
https://material.io/guidelines/patterns/settings.html#settings-usage


if use retrofit check:

https://inthecheesefactory.com/blog/say-goodbye-to-findviewbyid-with-data-binding-library/en

Wiring up recycler view:
https://stackoverflow.com/questions/29579811/changing-number-of-columns-with-gridlayoutmanager-and-recyclerview
https://classroom.udacity.
com/nanodegrees/nd801/parts/9bb83157-0407-47dc-b0c4-c3d4d7dc66df/modules/418d7086-8596-4c73-8d1b-8bddef80c116/lessons/c81cb722-d20a-495a-83c6-6890a6142aac/concepts/5ae0f3eb-e0ee-41ec-bfe4-bfa77a2a6d0d

Retrofit pb forum checked:
https://discussions.udacity.com/t/unknownhostexception-retrofit/619700
https://discussions.udacity.com/t/butterknife-where-to-bind-viewholder-views-in-recyclerview-adapter/642159/8

*/