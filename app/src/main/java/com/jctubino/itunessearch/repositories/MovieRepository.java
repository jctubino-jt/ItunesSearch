package com.jctubino.itunessearch.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jctubino.itunessearch.models.Movie;
import com.jctubino.itunessearch.request.MovieApiClient;

import java.util.List;

public class MovieRepository {

    private static MovieRepository instance;
    private MovieApiClient mMoviesApiClient;

    public static MovieRepository getInstance(){
        if(instance == null){
            instance = new MovieRepository();
        }
        return instance;
    }

    public MovieRepository() {
        mMoviesApiClient = MovieApiClient.getInstance();

    }

    public LiveData<List<Movie>> getMovies(){
        return mMoviesApiClient.getMovies();
    }
    public LiveData<Movie> getMovie(){
        return mMoviesApiClient.getMovie();
    }

    public void searchMovieById(int id){
        mMoviesApiClient.searchMovieById(id);
    }

    public void searchMoviesApi(String term, int limit){
    //if(pageNumber==0){
    mMoviesApiClient.searchMoviesApi(term, limit);

    }
}

