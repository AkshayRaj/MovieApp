import android.app.Application;

import com.ark.movieapp.tmdbhandlers.TmdbHandler;
import com.ark.movieapp.utils.Configuration;

/**
 * Created by Akshayraj on 9/19/15.
 */
public class MovieApplication extends Application {

    private static MovieApplication sInstance;
    private TmdbHandler mTmdbHandler;

    @Override
    public void onCreate(){
        super.onCreate();
        sInstance = this;
        mTmdbHandler = TmdbHandler.getInstance();
        mTmdbHandler.getFind().find(Configuration.DEFAULT_KEYWORD, null, null);
    }

    public static MovieApplication getInstance(){
        return sInstance;
    }
}
