package com.ark.movieapp.ui.fragment;

import android.app.Fragment;

import com.ark.movieapp.ui.adapter.MovieListAdapter;
import com.ark.movieapp.utils.MovieListFetcher;

import java.util.Date;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class MovieListFragment extends Fragment {

    private MovieListAdapter mMovieListAdapter;
    private MovieListFetcher mMovieListFetcher;

    private void showTripsList() {

        //check if Fragment is attached to parent
        if (!isAdded()) {
            return;
        }

        if(mMovieListFetcher == null){
            mMovieListFetcher = new MovieListFetcher(getActivity());//TestTripsFetcher();
        }
    }
}
