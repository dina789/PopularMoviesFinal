package com.example.dodo.popularmoviesfinal.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.dodo.popularmoviesfinal.Models.MoviesData;
import com.example.dodo.popularmoviesfinal.Models.ReviewModel;
import com.example.dodo.popularmoviesfinal.Models.Videomodel;
import com.example.dodo.popularmoviesfinal.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Details_Activity extends AppCompatActivity {
  //  private Multi_Type_Adap multi_adap;
    MoviesData moviesData;
    private List<Videomodel> videos;
    private List<ReviewModel> reviews;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);







//linear recycler view
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(   mLayoutManager );



// multi view type adapter:
//add the objects to my adapter
        //In the following line you are creating an adapter and passing the data..
        // This calls the adapter constructor, which takes the arguments and assigns them to your variables
     //   multi_adap = new Multi_Type_Adap(moviesData, reviews,videos, getApplicationContext());
       // recyclerView.setAdapter(multi_adap);


//create a ViewHolder for each view type and the conditionals to load each into your adapter


/*
• The onCreateViewHolder is inflating the layouts.

• The ViewHolderDetails class is catching all gets.

• The onBindViewHolder is getting gets through the ViewHolderDetails class.
 */




        Intent intentGetMovieDetails = getIntent();

        MoviesData movieModel = (MoviesData) intentGetMovieDetails.getSerializableExtra("movieModel");


        TextView text_release_date = findViewById(R.id.text_release_date);

        text_release_date.setText(movieModel.getReleaseDate().substring(0, 4));
        // TextView text_vote_average = findViewById(R.id.text_vote_average);

        TextView text_overview = findViewById(R.id.text_overview);
        TextView text_original_title = findViewById(R.id.text_original_title);
        ImageView image_poster = findViewById(R.id.image_poster);

        final Integer movieId = movieModel.getId();


        Picasso.with(getBaseContext()).load("http://image.tmdb.org/t/p/w500/" + movieModel.getPosterPath()).into(image_poster);

        RatingBar rating_bar = findViewById(R.id.rating_bar);

        text_original_title.setText(movieModel.getOriginalTitle()); //original title
        text_overview .setText(movieModel.getOverview());  //overview
        if (movieModel.getOverview() == "") {
            text_overview.setText("Overview:\n Overview not available !!");
        }


        double rate = movieModel.getVoteAverage();
        rate = rate /2;
       rating_bar.setRating((float) rate);


android.support.design.widget.FloatingActionButton fabButton = (android.support.design.widget.FloatingActionButton) findViewById(R.id.floating_favorite);

        fabButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                // Create a new intent to start an AddTaskActivity
                Intent GOtoFav = new Intent(Details_Activity.this, Favourite_Activity.class);
                startActivity(GOtoFav);
            }
        });


}}



/**
 *
 *https://discussions.udacity.com/t/recyclerview-view-trailers-and-reviews/310023/3
 *
 * https://developers.themoviedb.org/3/movies/get-movie-details
 * //onclick fav button
 * https://discussions.udacity.com/t/how-to-add-the-favourite-function/255658/2
 * https://discussions.udacity.com/t/favourite-movie-is-not-deleted/573209/10
 * //https://findusages.com/search/info.movito.themoviedbapi.model.MovieDb/getReleaseDate$0?offset=1
 */