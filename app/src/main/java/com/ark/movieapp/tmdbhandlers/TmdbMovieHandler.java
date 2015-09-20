package com.ark.movieapp.tmdbhandlers;

import android.media.Image;

import com.ark.movieapp.ui.model.Movie;
import com.ark.movieapp.utils.Configuration;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class TmdbMovieHandler extends TmdbMovies{

    private static TmdbMovieHandler sInstance;

    public TmdbMovieHandler(TmdbApi tmdbApi) {
        super(tmdbApi);
    }

    public Movie getMovie(int id){
        Movie movie = new Movie();
        movie.toMovie(super.getMovie(id, Configuration.DEFAULT_LANGUAGE, TmdbMovies.MovieMethod.keywords));
        return movie;
    }
}
