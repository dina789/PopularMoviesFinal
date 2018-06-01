package com.example.dodo.popularmoviesfinal.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dodo.popularmoviesfinal.Models.MoviesData;
import com.example.dodo.popularmoviesfinal.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>{


    /**
     * Created by Dodo on 3/30/2018.
     */


        private List<MoviesData> mMovieList;
        private final Context mContext;

        private final MoviesAdapterOnClickHandler mClickHandler;

        public void setItems(List<MoviesData> mMovieList) {
            this.mMovieList = mMovieList;
            notifyDataSetChanged();
        }

        /**
         * The interface that receives onClick messages.
         */
        public interface MoviesAdapterOnClickHandler {
            void onClick(long date);

            //recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
               // @Override
               // public void onClick(View view, int position) {
               //     Movie movie = movieList.get(position);
                 //   Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
              //  }
            void onClick(MoviesData moviesData);
        }

        /**
         * @param context      Used to talk to the UI and app resources
         * @param clickHandler The on-click handler for this adapter. This single handler is called
         *                     when an item is clicked.
         */
        public MoviesAdapter(List<MoviesData> mMovieList, Context context, MoviesAdapterOnClickHandler clickHandler) {
            this.mContext = context;
            this.mClickHandler = clickHandler;
            this.mMovieList = mMovieList;
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            return new MovieViewHolder(view);
        }



    @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {
            MoviesData movie = mMovieList.get(position);

            // This is how we use Picasso to load images from the internet.
            Picasso.with(mContext)
                    .load("http://image.tmdb.org/t/p/w185/" + movie.getPosterPath())
                    .placeholder(R.color.colorAccent)
                    .into(holder.image_poster);
        }

        @Override
        public int getItemCount() {
            return mMovieList.size();
        }

        public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public ImageView image_poster;

            public MovieViewHolder(View itemView) {
                super(itemView);
                image_poster = (ImageView) itemView.findViewById(R.id.image_poster);
            }

            @Override
            public void onClick(View v) {
                // itemView.setOnClickListener();
            }
        }
    }