package com.example.dodo.popularmoviesfinal.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.dodo.popularmoviesfinal.Models.MoviesData;
import com.example.dodo.popularmoviesfinal.R;
import com.squareup.picasso.Picasso;

public class Details_Activity extends AppCompatActivity {
    ImageView image_poster;
    TextView text_release_date, text_vote_average, text_overview, text_original_title;
    double rate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);

        Intent intentGetMovieDetails  = getIntent();

        MoviesData movieModel = (MoviesData) intentGetMovieDetails .getSerializableExtra("movieModel");



        text_release_date = (TextView) findViewById(R.id.text_release_date);

       text_release_date.setText(movieModel.getReleaseDate().substring(0, 4));
        text_vote_average = (TextView) findViewById(R.id.text_vote_average);
        text_overview = (TextView) findViewById(R.id.text_overview);
        text_original_title = (TextView) findViewById(R.id.text_original_title);

        RatingBar rating_bar=(RatingBar) findViewById(R.id.rating_bar);

        text_original_title.setText(movieModel.getTitle()); //original title
        text_overview .setText(movieModel.getOverview());  //overview
        if (movieModel.getOverview() == "") {
            text_overview.setText("Overview:\n Overview not available !!");
        }


      rate= movieModel.getVoteAverage(); //user rating
        rate=rate/2;
        rating_bar.setRating((float) rate);

        String originDate = movieModel.getReleaseDate();


        Picasso.with(getBaseContext()).load("http://image.tmdb.org/t/p/w500/" + movieModel.getPosterPath()).into(image_poster);

    }
    public void onBackButtonClick (View view)
    {
        //Back Code
        Intent intent = new Intent(Details_Activity.this , MainActivity.class);
        startActivity(intent);
    }

    }

//https://findusages.com/search/info.movito.themoviedbapi.model.MovieDb/getReleaseDate$0?offset=1