package com.example.dodo.popularmoviesfinal.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.dodo.popularmoviesfinal.R;

/**
 * Created by Dodo on 3/30/2018.
 */

public class MoviesAdapter {

    public  ImageView image_poster;


    public class MovieViewHolder extends RecyclerView.ViewHolder {


        public MovieViewHolder(View view) {
            super(view);


            image_poster = (ImageView) view.findViewById(R.id.image_poster);



    }
}}
/*https://classroom.udacity.com/nanodegrees/nd801/parts/9bb83157-0407-47dc-b0c4-c3d4d7dc66df/modules/418d7086-8596-4c73-8d1b-8bddef80c116/lessons/c81cb722-d20a-495a-83c6-6890a6142aac/concepts/ae70fe56-dbd3-446c-be43-b8da0f076ea6
https://discussions.udacity.com/t/let-s-share-popular-movies-stage-1-code-review-comments/635604

//sunshine forecastadapter


https://discussions.udacity.com/t/the-constructor-in-recycle-view-class/243441
https://willowtreeapps.com/ideas/android-fundamentals-working-with-the-recyclerview-adapter-and-viewholder-pattern
postpone using data binding!:

better use recycler view and data binding
https://discussions.udacity.com/t/data-binding-recycler-view-item/6071
https://blog.jayway.com/2015/12/08/recyclerview-and-databinding/

 */