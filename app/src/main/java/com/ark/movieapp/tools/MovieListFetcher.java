package com.ark.movieapp.tools;

/**
 * Created by Akshayraj on 9/19/15.
 */
public interface MovieListFetcher {
    public void fetchMoviesByKeyword(String keyword, MovieFetchListener listener);
    public void fetchMovies(MovieFetchListener listener);
}
