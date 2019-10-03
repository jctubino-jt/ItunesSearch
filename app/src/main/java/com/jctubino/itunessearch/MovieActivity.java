package com.jctubino.itunessearch;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.jctubino.itunessearch.models.Movie;
import com.jctubino.itunessearch.viewmodels.MovieViewModel;

import org.w3c.dom.Text;

public class MovieActivity extends BaseActivity {
    private static final String TAG = "MovieActivity";
    //UI Components
    private ImageView ivArtworkUrl100Details;
    private TextView tvTrackNameDetail;
    private TextView tvPrimaryGenreDetail;
    private TextView tvLongDescription;

    private MovieViewModel mMovieViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ivArtworkUrl100Details = findViewById(R.id.ivArtworkUrl100Detail);
        tvTrackNameDetail = findViewById(R.id.tvTrackNameDetail);
        tvPrimaryGenreDetail = findViewById(R.id.tvPrimaryGenreName);
        tvLongDescription = findViewById(R.id.tvLongDescription);

        //mMovieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);

        subscribeObservers();
        getIncomingIntent();


    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("movie")){
            Movie movie = getIntent().getParcelableExtra("movie");
            Log.d(TAG, "getIncomingIntent: ");
            mMovieViewModel.searchMovieById(movie.getTrackId());
        }
    }

    private void subscribeObservers(){
        mMovieViewModel.getMovie().observe(this, new Observer<Movie>() {
            @Override
            public void onChanged(Movie movie) {
                if(movie!=null){
                    Log.d(TAG, "onChanged: ------------------");
                    Log.d(TAG, "onChanged: " + movie.getTrackName());
                }
            }
        });
    }
}
