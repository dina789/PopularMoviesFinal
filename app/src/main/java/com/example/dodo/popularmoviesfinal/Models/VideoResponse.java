package com.example.dodo.popularmoviesfinal.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
public class VideoResponse {



    public class VideoModel implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("results")
        @Expose
        private List<VideoModel> results = null;
        private final static long serialVersionUID = -5066103928079960859L;

        /**
         * No args constructor for use in serialization
         */
        public VideoModel() {
        }

        /**
         * @param id
         * @param results
         */
        public VideoModel(Integer id, List<VideoModel> results) {
            super();
            this.id = id;
            this.results = results;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public List<VideoModel> getResults() {
            return results;
        }

        public void setResults(List<VideoModel> results) {
            this.results = results;
        }

    }


}
//https://developers.themoviedb.org/3/movies/get-movie-videos