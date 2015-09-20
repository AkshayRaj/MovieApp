package com.ark.movieapp;

import android.app.Activity;
import android.os.Bundle;

import ark.com.movieapp.R;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class MovieActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
}
