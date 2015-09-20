package com.ark.movieapp.tools;

import com.ark.movieapp.ui.model.Movie;

import java.util.List;

/**
 * Created by Akshayraj on 9/19/15.
 */
public interface MovieFetchListener {
    public void onMoviesFetched(List<Movie> movieList);
}
