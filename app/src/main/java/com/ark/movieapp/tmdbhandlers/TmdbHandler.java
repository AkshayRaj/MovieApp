package com.ark.movieapp.tmdbhandlers;

import com.ark.movieapp.ui.model.Movie;
import com.ark.movieapp.utils.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.keywords.Keyword;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class TmdbHandler extends TmdbApi{

    private static TmdbHandler sInstance;
    private TmdbMovieHandler mTmdbMovieHandler;

    private TmdbHandler(){
        super(Configuration.TMDB_API_KEY);
        mTmdbMovieHandler = new TmdbMovieHandler(this);
    }

    public static TmdbHandler getInstance(){
        if(sInstance == null){
            sInstance = new TmdbHandler();
        }
        return sInstance;
    }

    public List<Movie> searchForMovies(String searchText){
        ListIterator<Keyword> keywordListIterator = super.getKeywords()
                .getKeywordMovies(searchText, Configuration.DEFAULT_LANGUAGE, Configuration.DEFAULT_PAGE)
                .getResults()
                .listIterator();
        List<Movie> tmdbMovieHandlerList = new ArrayList<Movie>() {
        };

        //display first five results
        for(int i = 0 ; i < 5 ; i++) {
            if(keywordListIterator.hasNext()) {
                int id = keywordListIterator.next().getId();
                tmdbMovieHandlerList.add(mTmdbMovieHandler.getMovie(id));
            }
        }
        return tmdbMovieHandlerList;
    }
}
