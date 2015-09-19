package com.ark.movieapp.ui.model;

import info.movito.themoviedbapi.model.MovieDb;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class Movie extends MovieDb{

    private String mPosterPath;
    private String mTitle;
    private String mYear;
    private int mRating;
    private int mDuration;
    private String mDescription;

    public void toMovie(MovieDb movieDb){
        setTitle(movieDb.getTitle());
        setYear(movieDb.getReleaseDate());
        setDescription(movieDb.getOverview());
        setDuration(movieDb.getRuntime());
        setRating((int) movieDb.getUserRating());
        //mPosterPath = movieDb.getPosterPath();
    }

    public String getPoster() {
        return mPosterPath;
    }

    public void setPoster(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

    public int getRating() {
        return mRating;
    }

    public void setRating(int rating) {
        mRating = rating;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
