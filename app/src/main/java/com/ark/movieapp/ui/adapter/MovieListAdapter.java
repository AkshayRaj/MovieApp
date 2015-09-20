package com.ark.movieapp.ui.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ark.movieapp.ui.model.Movie;

import java.util.List;

import ark.com.movieapp.R;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class MovieListAdapter extends BaseAdapter{

    private List<Movie> mMovieList;
    private Context mContext;

    public MovieListAdapter(Context context, List<Movie> data) {
        mContext = context;
        mMovieList = data;
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
    public View getView(int i, View view, ViewGroup parent) {
        MovieView movieView;

        if (view == null) {
            view = View.inflate(mContext, R.layout.item_movielist_summary, null);

            movieView = new MovieView();
            //movieView.moviePoster = (Image) view.findViewById(R.id.item_movieList_moviePoster_imageView);
            movieView.movieName = (TextView) view.findViewById(R.id.item_movieList_movieName_textView);
            movieView.movieYear = (TextView) view.findViewById(R.id.item_movieList_movieYear_textView);

            view.setTag(movieView);
        }

        movieView = (MovieView) view.getTag();

        Movie movie = getItem(i);
        movieView.movieName.setText(movie.getTitle());
        movieView.movieName.setText(movie.getYear());
        //movieView.moviePoster;
        return view;

    }

    private class MovieView {
        Image moviePoster;
        TextView movieName;
        TextView movieYear;
    }
}
