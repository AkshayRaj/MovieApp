package com.ark.movieapp.cloud;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private static final String LOG_TAG = VolleySingleton.class.getSimpleName();
    private static final String TAG = "TmdbRequest";
    private static VolleySingleton instance;
    private RequestQueue mRequestQueue;

    private VolleySingleton(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static VolleySingleton getInstance(Context context){
        if(instance == null){
            instance = new VolleySingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request){
        Log.d(LOG_TAG, "addToRequestQueue()");
        request.setTag(TAG);
        getRequestQueue().add(request);
    }
}
