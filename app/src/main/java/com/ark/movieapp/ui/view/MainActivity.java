package com.ark.movieapp.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import ark.com.movieapp.R;

public class MainActivity extends Activity {

    public static final String EXTRA_QUERY = "EXTRA_QUERY";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /**
     * Fires an intent to the {@link MovieListActivity} with the query.
     * {@link MovieListActivity} does all the downloading and rendering.
     * @param view
     */
    public void queryTMDB(View view) {
        Intent intent = new Intent(this, MovieListActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String query = editText.getText().toString();
        intent.putExtra(EXTRA_QUERY, query);
        startActivity(intent);
    }
}
