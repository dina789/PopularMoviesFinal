package com.example.dodo.popularmoviesfinal.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class MovieResponse  {

@SerializedName("results")

        private List<MoviesData> results;

          public List<MoviesData> getResults() {
              return results;
          }

    public void setResults(List<MoviesData> results) {
        this.results = results;
    }
}