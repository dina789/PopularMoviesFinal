package com.example.dodo.popularmoviesfinal.Network;


import com.example.dodo.popularmoviesfinal.Models.MoviesData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Dodo on 3/31/2018.
 */

public interface ApiInterface {

    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter




  @GET("/3/movie/{category}")
  Call<List<MoviesData> >getMovieList(@Path("category") String category, @Query("api_key") String key);

 // @GET("movie/top_rated")
 // Call<MoviesData> getTopRatedMovies(@Query("api_key") String apiKey);



}
/*
on endpoint from the forum;

https://discussions.udacity.com/t/using-retrofit-firsttime/366768/9


https://discussions.udacity.com/t/retrofit-help-building-movie-id-reviews-endpoint/385052/3
http://square.github.io/retrofit/

https://stackoverflow.com/questions/27816507/retrofit-multiple-endpoints-with-same-restadapter/27981993#27981993

Path – variable substitution for the API endpoint. For example movie id will be swapped for{id} in the URL endpoint.

@Query – specifies the query key name with the value of the annotated parameter.

@Body – payload for the POST call

@Header – specifies the header with the value of the annotated parameter
 */