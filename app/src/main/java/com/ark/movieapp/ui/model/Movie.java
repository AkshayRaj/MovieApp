package com.ark.movieapp.ui.model;

import ark.com.movieapp.R;

public class Movie {
    public static final String POSTER_URL = "http://image.tmdb.org/t/p/original";
    private final int mId;
    private final String mPosterPath;
    private final String mBackdropPath;
    private final String mTitle;
    private final String mYear;
    private final String mRating;
    private final String mDuration;
    private final String mDescription;
    private final int mFakeResId = R.drawable.app_icon;
    
    private Movie(MovieBuilder movieBuilder) {
        mId = movieBuilder.id;
        mPosterPath = movieBuilder.posterPath;
        mBackdropPath = movieBuilder.backDropPath;
        mTitle = movieBuilder.originalTitle;
        mYear = movieBuilder.releaseDate;
        mRating = movieBuilder.popularity;
        mDuration = movieBuilder.duration;
        mDescription = movieBuilder.overview;
    }

    public static class MovieBuilder {
        private String overview;
        private String originalTitle;
        private int id;
        private String popularity;
        private String posterPath;
        private String releaseDate;
        private String duration;
        private String backDropPath;

        public MovieBuilder(int id) {
            this.id = id;
        }

        public MovieBuilder setOverview(String overview) {
            this.overview = overview;
            return this;
        }

        public MovieBuilder setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
            return this;
        }

        public MovieBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public MovieBuilder setPopularity(String popularity) {
            this.popularity = popularity;
            return this;
        }

        public MovieBuilder setPosterPath(String posterPath) {
            this.posterPath = posterPath;
            return this;
        }

        public MovieBuilder setBackDropPath(String backDropPath) {
            this.backDropPath = backDropPath;
            return this;
        }

        public MovieBuilder setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public MovieBuilder setDuration(String duration) {
            this.duration = duration;
            return this;
        }
        
        public Movie build() {
            return new Movie(this);
        }
    }
    
    public static MovieBuilder newBuilder(int id) {
        return new MovieBuilder(id);
    }

    public int getId() {
        return mId;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getYear() {
        return mYear;
    }

    public String getRating() {
        return "Rating: " + mRating;
    }

    public String getDuration() {
        return "Running Time : " + mDuration;
    }

    public String getOverview() {
        return "Overview: \n" + mDescription;
    }

    @Override
    public String toString() {
        return getTitle();
    }
    
}
