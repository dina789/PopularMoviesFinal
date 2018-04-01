package com.example.dodo.popularmoviesfinal;

import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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

public class MainActivity extends AppCompatActivity {

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

//yet, grid layout manager

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

            @Override
            public void onResponse(Call<MoviesData> call, Response<MoviesData> response) {
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
}














/*

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




*/