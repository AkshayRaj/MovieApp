package com.ark.movieapp.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ark.movieapp.tools.MovieFetchHelper;
import com.ark.movieapp.tools.MovieListFetcher;
import com.ark.movieapp.tmdbhandlers.TmdbHandler;
import com.ark.movieapp.ui.adapter.MovieListAdapter;
import com.ark.movieapp.ui.model.Movie;

import java.util.List;

import ark.com.movieapp.R;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class MovieListFragment extends Fragment {

    private MovieListAdapter mMovieListAdapter;
    private ListView mMovieListView;
    // "No Data Found" message
    private LinearLayout mNoDataLinearLayout;
    private ProgressBar mNoDataProgressBar;
    private TextView    mNoDataTextView;
    private TmdbHandler mTmdbHandler;
    private MovieListFetcher mMovieListFetcher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mTmdbHandler = TmdbHandler.getInstance();
        View rootView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        updateFragment(rootView);

        return rootView;
    }

    private void updateFragment(View rootView){
        // "No Data Found" message
        mNoDataLinearLayout = (LinearLayout) rootView.findViewById(R.id.fragment_movieList_nodata_LinearLayout);
        mNoDataTextView = (TextView) rootView.findViewById(R.id.fragment_movieList_nodata_TextView);
        mNoDataProgressBar = (ProgressBar) rootView.findViewById(R.id.fragment_movieList_nodata_ProgressBar);
        // movieListView
        mMovieListView = (ListView) rootView.findViewById(R.id.fragment_movieList_listView);
        mMovieListView.setEmptyView(mNoDataLinearLayout);
        setEmptyViewMessage(getString(R.string.search_for_movie));

        mMovieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // 1. Get item position and so get the ID of the object.
                Movie movie = (Movie) adapterView.getAdapter().getItem(i);
                // 2. Pass this to the next activity to show the details page.
                Intent intent = new Intent(getActivity(), MovieDetailsFragment.class);
                // 3. Start the Trip Details screen
                startActivity(intent);
            }
        });
    }

    private void setEmptyViewMessage(String message){
        mNoDataProgressBar.setVisibility(View.VISIBLE);
        mNoDataTextView.setText(message);
    }

    private void showTripsList() {
        //check if Fragment is attached to parent
        if (!isAdded()) {
            return;
        }

        // Get the list of trips from Cache.
        List<Movie> movieList = mTmdbHandler.searchForMovies("");

        // If the trip data is not yet in the cache, then fetch it!
        if(movieList == null){

            // Initiate a request
            if(mMovieListFetcher == null){
                mMovieListFetcher = new MovieFetchHelper(getActivity());//TestTripsFetcher();
            }

            // Show a "loading message"
            mMovieListView.setAdapter(null);
            setEmptyViewMessage(getString(R.string.loading_movies));

        } else {    // The trip data for this day is already cached.

            prepareListView(movieList);
        }
    }

    private void prepareListView(List<Movie> trips){

        if(trips.size() == 0){   // No trips found!

            mMovieListView.setAdapter(null);
            Activity activity = getActivity();
            if(activity != null){
                setEmptyViewMessage(activity.getResources().getString(R.string.nothing_to_show));
            }

            if(mMovieListAdapter == null){
                mMovieListAdapter = new MovieListAdapter(getActivity(), trips);
            } else {
                mMovieListAdapter.setMovieList(trips);
            }

            mMovieListView.setAdapter(mMovieListAdapter);
            mMovieListAdapter.notifyDataSetChanged();

        }
    }
}
