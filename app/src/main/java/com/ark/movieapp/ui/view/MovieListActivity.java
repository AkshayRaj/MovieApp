package com.ark.movieapp.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ark.movieapp.cloud.CloudManager;
import com.ark.movieapp.cloud.ResponseListener;
import com.ark.movieapp.ui.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

import ark.com.movieapp.R;

public class MovieListActivity extends Activity {

    private static final String LOG_TAG = MovieListActivity.class.getSimpleName();
    CloudManager mCloudManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        // Get the intent to get the query.
        Intent intent = getIntent();
        String query = intent.getStringExtra(MainActivity.EXTRA_QUERY);
        
        // Check if the NetworkConnection is active and connected.
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        mCloudManager = CloudManager.getInstance(this);
        if (networkInfo != null && networkInfo.isConnected()) {
            new TmdbHandler().execute(query);
        } else {
            TextView textView = new TextView(this);
            textView.setText("No network connection.");
            setContentView(textView);
        }
        
    }
    
    /**
     * Updates the View with the results. This is called asynchronously
     * when the results are ready.
     * @param result The results to be presented to the user.
     */
    public void updateViewWithResults(ArrayList<Movie> result) {
        ListView listView = new ListView(this);
        Log.d("updateViewWithResults", result.toString());
        // Add results to listView.
        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, R.layout.movie_result_list_item, result);
        listView.setAdapter(adapter);
        // Update Activity to show listView
        setContentView(listView);
    }
    
    private class TmdbHandler extends AsyncTask {

        private static final String LOG_TAG = "TmdbHandler";
        private boolean mResponseReceived = false;
        
        @Override
        protected ArrayList<Movie> doInBackground(Object... params) {
            try {
                return searchIMDB((String) params[0]);
            } catch (IOException e) {
                return null;
            }
        }
        
        @Override
        protected void onPostExecute(Object result) {
            updateViewWithResults((ArrayList<Movie>) result);
        };

        /**
         * Searches IMDBs API for the given query
         *
         * @param query The query to search.
         * @return A list of all hits.
         */
        public ArrayList<Movie> searchIMDB(String query) throws IOException {

            ArrayList<Movie> movieList = null;
            movieList = useVolleySync(query);

            return movieList;
        }

        private ArrayList<Movie> useVolleySync(String query){
            return getMovieData(mCloudManager.searchForMovies(query, null));
        }

        private ArrayList<Movie> useVolleyAsync(String query) {
            JSONObject response = mCloudManager.searchForMovies(query, new ResponseListener() {
                @Override
                public void onResponseReceived(Object result) {
                    Log.d(MovieListActivity.LOG_TAG, "onSuccess");
                    setResponseReceived(true);
                }

                @Override
                public void onResponseFailed(Exception errorMessage) {
                    Log.d(MovieListActivity.LOG_TAG, "onFailure(): " + errorMessage.getMessage());
                }
            });
            // waiting for response
            while(!isResponseReceived()){
                //This is bad.
            }
            return getMovieData(response);
        }

        private ArrayList<Movie> getMovieData(JSONObject result) {
            String responseString = result.toString();
            ArrayList<Movie> movieArrayList = new ArrayList<Movie>();
            try {
                JSONObject jsonObject = new JSONObject(responseString);
                JSONArray array = (JSONArray) jsonObject.get("results");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonMovieObject = array.getJSONObject(i);
                    Movie.MovieBuilder movieBuilder = Movie.newBuilder(
                            Integer.parseInt(jsonMovieObject.getString("id")))
                            .setPosterPath(jsonMovieObject.getString("poster_path"))
                            .setOriginalTitle(jsonMovieObject.getString("original_title"))
                            .setReleaseDate(jsonMovieObject.getString("release_date"))
                            .setPopularity(jsonMovieObject.getString("popularity"))
                            .setOverview(jsonMovieObject.getString("overview"));
                    movieArrayList.add(movieBuilder.build());
                }
            } catch (JSONException e) {
                System.err.println(e);
                Log.d(LOG_TAG, "Error parsing response: " + responseString);
            }
            return movieArrayList;
        }

        public void setResponseReceived(boolean responseReceived) {
            mResponseReceived = responseReceived;
        }

        public boolean isResponseReceived() {
            return mResponseReceived;
        }
    }

}
