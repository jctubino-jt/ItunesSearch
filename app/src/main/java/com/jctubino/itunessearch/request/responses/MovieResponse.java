package com.jctubino.itunessearch.request.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jctubino.itunessearch.models.Movie;


//Cant find a way to implement this since iTunes api doesn't search by trackId
public class MovieResponse {

    @SerializedName("id")
    @Expose()
    private int id;
}
