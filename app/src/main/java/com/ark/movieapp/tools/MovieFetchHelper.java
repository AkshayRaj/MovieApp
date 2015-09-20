package com.ark.movieapp.tools;

import android.content.Context;
import android.os.AsyncTask;

import com.ark.movieapp.tmdbhandlers.TmdbHandler;
import com.ark.movieapp.ui.model.Movie;

import java.util.List;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class MovieFetchHelper implements MovieListFetcher {

    private Context mContext;
    private TmdbHandler mTmdbHandler;
    private String mKeyword;

    public MovieFetchHelper(Context context) {
        mContext = context;
        mTmdbHandler = TmdbHandler.getInstance();
    }

    @Override
    public void fetchMoviesByKeyword(String keyword, MovieFetchListener movieFetchListener) {
        mKeyword = keyword;
        new MovieFetchAsyncTask(this, movieFetchListener).execute();
    }

    @Override
    public void fetchMovies(MovieFetchListener listener) {

    }

    private class MovieFetchAsyncTask extends AsyncTask<Void, Void, Void> {

        private MovieFetchHelper movieFetchHelper;
        MovieFetchListener mMovieFetchListener;

        List<Movie> movieList;


        public MovieFetchAsyncTask(MovieFetchHelper movieFetchHelper, MovieFetchListener tripFetchListener) {
            this.movieFetchHelper = movieFetchHelper;
            mMovieFetchListener = tripFetchListener;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            movieList = movieFetchHelper.mTmdbHandler.searchForMovies(movieFetchHelper.mKeyword);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (mMovieFetchListener != null) {
                mMovieFetchListener.onMoviesFetched(movieList);
            }
        }
    }
}

