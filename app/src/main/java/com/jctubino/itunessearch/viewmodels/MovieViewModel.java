package com.jctubino.itunessearch.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import com.jctubino.itunessearch.models.Movie;
import com.jctubino.itunessearch.repositories.MovieRepository;

public class MovieViewModel extends ViewModelProviders {

    private MovieRepository mMovieRepository;

    public MovieViewModel() {
        mMovieRepository = MovieRepository.getInstance();
    }

    public LiveData<Movie> getMovie(){
        return mMovieRepository.getMovie();
    }

    public void searchMovieById(int id){
        mMovieRepository.searchMovieById(id);
    }
}
