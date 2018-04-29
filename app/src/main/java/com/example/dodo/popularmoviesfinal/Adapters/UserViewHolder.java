package com.example.dodo.popularmoviesfinal.Adapters;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dodo.popularmoviesfinal.Models.MoviesData;
import com.example.dodo.popularmoviesfinal.R;
import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;
public class UserViewHolder extends BaseViewHolder<MoviesData, OnRecyclerItemClickListener> {
    public final ImageView image_poster;
    private List<MoviesData> mMovieList;
    private Context mContext;
    public UserViewHolder (View itemView, OnRecyclerItemClickListener listener) {
        super(itemView, listener);
        // initialize view and set click listener
        image_poster = itemView.findViewById(R.id.image_poster);
        if (listener != null) {
            itemView.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
        }
    }
    @Override
    public void onBind(MoviesData item) {
        // bind data to the views
       // nameTv.setText(item.getName());
        Picasso.with(mContext)
                .load("http://image.tmdb.org/t/p/w185/" + item.getPosterPath())
                .placeholder(R.color.colorAccent)
                .into(image_poster);
    }
                public static class MoviesAdapter extends GenericRecyclerViewAdapter<MoviesData, OnRecyclerItemClickListener, UserViewHolder> {

        public MoviesAdapter(Context context, OnRecyclerItemClickListener listener) {
            super(context, listener);
        }



                    @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new UserViewHolder(inflate(R.layout.list_item, parent), getListener());
        }
    }}
//https://android.jlelse.eu/recyclerview-adapter-a-piece-of-cake-with-the-generic-adapter-766cedffd81