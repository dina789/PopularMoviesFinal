package Adapters;

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
