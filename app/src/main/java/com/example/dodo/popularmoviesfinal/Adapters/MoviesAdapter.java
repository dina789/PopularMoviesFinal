package com.example.dodo.popularmoviesfinal.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dodo.popularmoviesfinal.Models.MoviesData;
import com.example.dodo.popularmoviesfinal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dodo on 3/30/2018.
 */
//da yextend el view holder
public class MoviesAdapter extends RecyclerView.Adapter < MoviesAdapter.MovieViewHolder>
{
    private List<MoviesData> mMovieList;
    private boolean mNotifyOnChange = true;
    private Cursor mCursor;
    private final Context  mContext;
    public  ImageView image_poster;
    // public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";

   final private MoviesAdapterOnClickHandler mClickHandler;




    /**
     * The interface that receives onClick messages.
     *
     */

    public interface MoviesAdapterOnClickHandler {
        void onClick(long date);
    }


    /**

     *
     * @param context      Used to talk to the UI and app resources
     * @param clickHandler The on-click handler for this adapter. This single handler is called
     *                     when an item is clicked.
     */


    public MoviesAdapter(@NonNull Context context, MoviesAdapterOnClickHandler clickHandler )
    {

        mContext = context;
        mClickHandler = clickHandler;

        this.mMovieList = new ArrayList<>();
    }



    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        {
            {
                View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
                return new MovieViewHolder (view);
            }
        }

    }






  //OnBindViewHolder is called by the RecyclerView to display the data at the specified
 //position. In this method,


    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        String IMAGE_URL_BASE_PATH  = "http://api.themoviedb.org/3/movie/popular?";

    String image_url = IMAGE_URL_BASE_PATH + MoviesData.get(position);

        MoviesData movie = mMovieList.get(position);

        // This is how we use Picasso to load images from the internet.
        Picasso.with(mContext)
                .load(movie.getPosterPath())
                //  .load(url)
                .placeholder(R.color.colorAccent)
                .into(holder.image_poster);





    }

//https://www.101apps.co.za/index.php/articles/android-recyclerview-and-picasso-tutorial.html




    @Override
    public int getItemCount() {
        if (null == mCursor) return 0;
        return mCursor.getCount();
    }

    void swapCursor(Cursor newCursor) {
        mCursor = newCursor;
        notifyDataSetChanged();
    }

  //  public void setMovieList(List<Movie> movieList)
   // {
      //  this.mMovieList.clear();
      //  this.mMovieList.addAll( mMovieList);

        // The adapter needs to know that the data has changed. If we don't call this, app will crash.


     //   notifyDataSetChanged();
   // }

//done yet implement on click listener

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView image_poster;

        public MovieViewHolder(View itemView)
        {
            super(itemView);
            image_poster= (ImageView) itemView.findViewById(R.id.image_poster);
        }


        @Override
        public void onClick(View v) {

          // itemView.setOnClickListener();

        }
    }


}


//https://www.youtube.com/watch?v=OOLFhtyCspA&t=3625s

//https://android.googlesource.com/platform/frameworks/base/+/master/core/java/android/widget/ArrayAdapter.java

   // http://mateoj.com/2015/10/06/creating-movies-app-retrofit-picasso-android/
/*  https://classroom.udacity.com/nanodegrees/nd801/parts/9bb83157-0407-47dc-b0c4-c3d4d7dc66df/modules/418d7086-8596-4c73-8d1b-8bddef80c116/lessons/c81cb722-d20a-495a-83c6-6890a6142aac/concepts/ae70fe56-dbd3-446c-be43-b8da0f076ea6
https://discussions.udacity.com/t/let-s-share-popular-movies-stage-1-code-review-comments/635604
https://www.androidhive.info/2017/09/android-recyclerview-swipe-delete-undo-using-itemtouchhelper/
//sunshine forecastadapter
for notify data set changed
//https://discussions.udacity.com/t/adapter-notifydatasetchanged-is-not-working/630771/6

//using cursor:
https://developer.android.com/reference/android/database/Cursor.html
Imp refrence:
https://discussions.udacity.com/t/popular-movies-stage-1-json/601025/37
https://discussions.udacity.com/t/popular-movies-stage-1-json/601025/11

// why recycler view don't need a scroll view:
https://discussions.udacity.com/t/database-implementation/623950/9
https://discussions.udacity.com/t/the-constructor-in-recycle-view-class/243441

for recycler view implementaion
https://willowtreeapps.com/ideas/android-fundamentals-working-with-the-recyclerview-adapter-and-viewholder-pattern

postpone using data binding!:

better use recycler view and data binding
https://discussions.udacity.com/t/data-binding-recycler-view-item/6071
https://blog.jayway.com/2015/12/08/recyclerview-and-databinding/

 */