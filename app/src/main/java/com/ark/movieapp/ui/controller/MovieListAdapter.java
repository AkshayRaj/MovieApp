package com.ark.movieapp.ui.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ark.movieapp.cloud.VolleyHelpers.PosterLoader;
import com.ark.movieapp.ui.model.Movie;

import java.util.List;

import ark.com.movieapp.R;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class MovieListAdapter extends BaseAdapter{

    private List<Movie> mMovieList;
    LayoutInflater mInflater;
    private Context mContext;

    public MovieListAdapter(Context context, List<Movie> movieList) {
        mContext = context;
        mMovieList = movieList;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setMovieList(List<Movie> trips){
        mMovieList = trips;
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Movie getItem(int position) {
        return mMovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieViewHolder mViewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layout_list_item, parent, false);
            mViewHolder = new MovieViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MovieViewHolder) convertView.getTag();
        }

        Movie movie = getItem(position);

        new PosterLoader(mViewHolder.moviePoster).execute(Movie.POSTER_URL + movie.getPosterPath());
        mViewHolder.movieName.setText(movie.getTitle());
        mViewHolder.movieYear.setText(movie.getYear());
//        mViewHolder.moviePoster.setImageResource(R.drawable.star1);

        return convertView;

    }

    private class MovieViewHolder {
        ImageView moviePoster;
        TextView movieName;
        TextView movieYear;

        public MovieViewHolder(View item) {
            movieName = (TextView) item.findViewById(R.id.movieTitle);
            movieYear = (TextView) item.findViewById(R.id.movieYear);
            moviePoster = (ImageView) item.findViewById(R.id.moviePoster);
        }
    }
}
