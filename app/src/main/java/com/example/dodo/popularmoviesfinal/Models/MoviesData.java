package com.example.dodo.popularmoviesfinal.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


    public class MoviesData implements Serializable{

        @SerializedName("vote_count")
        @Expose
        private Integer voteCount;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("video")
        @Expose
        private Boolean video;
        @SerializedName("vote_average")
        @Expose
        private Double voteAverage;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("popularity")
        @Expose
        private Double popularity;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;

        @SerializedName("original_title")
        @Expose
        private String originalTitle;
    @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        private final static long serialVersionUID = 5730448827994946968L;




        public MoviesData(String posterPath,  String overview, String releaseDate, Integer id,
                          String originalTitle,  Double popularity,
                          Integer voteCount, Double voteAverage) {
            this.posterPath = posterPath;

            this.overview = overview;
            this.releaseDate = releaseDate;

            this.id = id;
            this.originalTitle = originalTitle;

            this.popularity = popularity;
            this.voteCount = voteCount;
            this.voteAverage = voteAverage;
        }


        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }


        public Double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(Double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Double getPopularity() {
            return popularity;
        }

        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }


        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public static int get(int position) {
            return position;
        }

    }

    /*
    //https://github.com/dina789/Web1

    http://api.themoviedb.org/3/movie/popular?api_key=
     */