package com.ark.movieapp.ui.model;

public class Movie {
    private final int mId;
    private final String mPosterPath;
    private final String mTitle;
    private final String mYear;
    private final String mRating;
    private final String mDuration = "90";
    private final String mDescription;
    
    private Movie(MovieBuilder movieBuilder) {
        mId = movieBuilder.id;
        mPosterPath = movieBuilder.posterPath;
        mTitle = movieBuilder.originalTitle;
        mYear = movieBuilder.releaseDate;
        mRating = movieBuilder.popularity;
        //mDuration = movieBuilder.duration;
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

    public String getTitle() {
        return mTitle;
    }

    public String getYear() {
        return mYear;
    }

    public String getRating() {
        return mRating;
    }

    public String getDuration() {
        return mDuration;
    }

    public String getOverview() {
        return mDescription;
    }

    @Override
    public String toString() {
        return getTitle();
    }
    
}
