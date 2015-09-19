package com.ark.movieapp.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ark.movieapp.ui.model.Movie;

import java.util.List;

import ark.com.movieapp.R;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class MovieListAdapter extends BaseAdapter{

    private List<Movie> mList;

    public void setMovieList(List<Movie> trips){
        mList = trips;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Movie getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        MovieView movieView;

        if (view == null) {
            view = View.inflate(mContext, R.layout.item_movieList_summary, null);

            movieView = new MovieView();
            movieView.moviePoster = (ImageView) view.findViewById(R.id.item_movieList_moviePoster_imageView);
            movieView.movieName = (TextView) view.findViewById(R.id.item_movieList_movieName_textView);
            movieView.movieYear = (TextView) view.findViewById(R.id.item_movieList_movieYear);

            view.setTag(movieView);
        }

        movieView = (MovieView) view.getTag();

        Movie movie = getItem(position);

        movieView.moviePoster.setImageAlpha(movie.getPoster());

        return view;

    }

    private class MovieView {
        ImageView moviePoster;
        TextView movieName;
        TextView movieYear;
    }
}
