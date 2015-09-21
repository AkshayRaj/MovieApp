package com.ark.movieapp.ui.view;

import android.app.Activity;
import android.os.Bundle;

import ark.com.movieapp.R;

/**
 *
 */
public class MovieDetailsActivity extends Activity {
    public static final String EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
    }
}
