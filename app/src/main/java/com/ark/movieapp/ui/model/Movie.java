package com.ark.movieapp.ui.model;

import android.media.Image;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class Movie {

    int mPoster;
    String mTitle;
    String mYear;
    int mRating;
    int mDuration;
    String mDescription;

    public int getPoster() {
        return mPoster;
    }

    public void setPoster(int poster) {
        mPoster = poster;
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
