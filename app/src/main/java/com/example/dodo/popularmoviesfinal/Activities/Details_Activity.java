package com.example.dodo.popularmoviesfinal.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.dodo.popularmoviesfinal.Models.MoviesData;
import com.example.dodo.popularmoviesfinal.R;
import com.squareup.picasso.Picasso;

public class Details_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);

        Intent intentGetMovieDetails  = getIntent();

        MoviesData movieModel = (MoviesData) intentGetMovieDetails .getSerializableExtra("movieModel");


        TextView text_release_date = findViewById(R.id.text_release_date);

       text_release_date.setText(movieModel.getReleaseDate().substring(0, 4));
       // TextView text_vote_average = findViewById(R.id.text_vote_average);

        TextView text_overview = findViewById(R.id.text_overview);
        TextView text_original_title = findViewById(R.id.text_original_title);
        ImageView image_poster = findViewById(R.id.image_poster);

    final Integer movieId = movieModel.getId();


        Picasso.with(getBaseContext()).load("http://image.tmdb.org/t/p/w500/" + movieModel.getPosterPath()).into(image_poster);

        RatingBar rating_bar= findViewById(R.id.rating_bar);

        text_original_title.setText(movieModel.getOriginalTitle()); //original title
        text_overview .setText(movieModel.getOverview());  //overview
        if (movieModel.getOverview() == "") {
            text_overview.setText("Overview:\n Overview not available !!");
        }


        double rate = movieModel.getVoteAverage();
        rate = rate /2;
       rating_bar.setRating((float) rate);



   /** for reference
     * Setup the floating button of add to favourite
     */
   /**
    private void setupFloatingActionButton() {
   floating_favorite= (FloatingActionButton) findViewById(R.id.floating_favorite);

        floating_favorite.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favoritesService.isFavorite(bundle)) {
                    favoritesService.removeFromFavorites(bundle);
                    Snackbar snackbar = Snackbar.make(coordinatorLayout, "Romoved from Favourites", Snackbar.LENGTH_LONG);
                    snackbar.show();
                        //Utility.showToast(getApplicationContext(), "Removed from Favourite!");
                    fab.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_thumb_up_white_24dp));
                } else {
                    favoritesService.addToFavorites(bundle);
                    Snackbar snackbar = Snackbar.make(coordinatorLayout, "Added to Favourites", Snackbar.LENGTH_LONG);
                    snackbar.show();
                        //Utility.showToast(getApplicationContext(), "Added to Favourite!");
                        fab.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_thumb_down_white_24dp));
                }
            }
        });
    }


**/

 }






public void onClickAddtofav(String movieTitle, String movieId) {}

    ContentValues contentValues = new android.content.ContentValues();
       contentValues.put(Fav_contract.Favourite_entry.COLUMN_MOVIE_FAVOURITE_TITLE,text_original_title );
    contentValues.put(Fav_contract.Favourite_entry.COLUMN_MOVIE_ID, movieId );

    Uri uri = getContentResolver().insert(Fav_contract.Favourite_entry.CONTENT_URI, contentValues);


}/**
//onclick fav button
https://discussions.udacity.com/t/how-to-add-the-favourite-function/255658/2
https://discussions.udacity.com/t/favourite-movie-is-not-deleted/573209/10
//https://findusages.com/search/info.movito.themoviedbapi.model.MovieDb/getReleaseDate$0?offset=1
*/