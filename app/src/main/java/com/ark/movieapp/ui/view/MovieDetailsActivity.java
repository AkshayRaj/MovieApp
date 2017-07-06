package com.ark.movieapp.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.ark.movieapp.cloud.VolleyHelpers.PosterLoader;
import com.ark.movieapp.ui.model.Movie;

import ark.com.movieapp.R;

/**
 *
 */
public class MovieDetailsActivity extends Activity {
    public static final String EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID";
    private static final int DEFAULT_ID = 603;
    public static final String EXTRA_MOVIE_BACKDROP = "EXTRA_MOVIE_BACKDROP";
    public static final String EXTRA_MOVIE_NAME = "EXTRA_MOVIE_NAME";
    public static final String EXTRA_MOVIE_YEAR = "EXTRA_MOVIE_YEAR";
    public static final String EXTRA_MOVIE_RATING = "EXTRA_MOVIE_RATING";
    public static final String EXTRA_MOVIE_DURATION = "EXTRA_MOVIE_DURATION";
    public static final String EXTRA_MOVIE_DESCRIPTION = "EXTRA_MOVIE_DESCRIPTION";
    private static final String LOG_TAG = MovieDetailsActivity.class.getSimpleName();

    ImageView mMoviePoster;
    TextView mMovieName;
    TextView mMovieYear;
    TextView mMovieRating;
    TextView mMovieDuration;
    TextView mMovieDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        // Get the intent to get movie details
        Intent intent = getIntent();
        int id = intent.getIntExtra(MovieDetailsActivity.EXTRA_MOVIE_ID, DEFAULT_ID);
        String moviePosterPath = intent.getStringExtra(EXTRA_MOVIE_BACKDROP);
        String movieName = intent.getStringExtra(EXTRA_MOVIE_NAME);
        String movieYear = intent.getStringExtra(EXTRA_MOVIE_YEAR);
        String movieRating = intent.getStringExtra(EXTRA_MOVIE_RATING);
        String movieDuration = intent.getStringExtra(EXTRA_MOVIE_DURATION);
        String movieDescription = intent.getStringExtra(EXTRA_MOVIE_DESCRIPTION);

        mMoviePoster = (ImageView) findViewById(R.id.movie_poster);
        mMovieName = (TextView) findViewById(R.id.movie_name);
        mMovieYear = (TextView) findViewById(R.id.movie_year);
        mMovieRating = (TextView) findViewById(R.id.movie_rating);
        mMovieDuration = (TextView) findViewById(R.id.movie_duration);
        mMovieDescription = (TextView) findViewById(R.id.movie_description);
        mMovieDescription.setMovementMethod(new ScrollingMovementMethod());

        new PosterLoader(mMoviePoster).execute(Movie.POSTER_URL + moviePosterPath);
        mMovieName.setText(movieName);
        mMovieYear.setText(movieYear);
        mMovieRating.setText(movieRating);
        mMovieDuration.setText(movieDuration);
        mMovieDescription.setText(movieDescription);//

    }

//    private class PosterLoader extends AsyncTask{
//
//        @Override
//        protected Bitmap doInBackground(Object... params) {
//            try {
//                return getImageBitmap((String) params[0]);
//            }catch (Exception e){
//                return null;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(Object result){
//            mMoviePoster.setImageBitmap((Bitmap) result);
//        }
//    }
//
//    private Bitmap getImageBitmap(String url) {
//        Bitmap bm = null;
//        try {
//            URL aURL = new URL(url);
//            URLConnection conn = aURL.openConnection();
//            conn.connect();
//            InputStream is = conn.getInputStream();
//            BufferedInputStream bis = new BufferedInputStream(is);
//            bm = BitmapFactory.decodeStream(bis);
//            bis.close();
//            is.close();
//        } catch (IOException e) {
//            Log.e(LOG_TAG, "Error getting bitmap", e);
//        }
//        return bm;
//    }
}
