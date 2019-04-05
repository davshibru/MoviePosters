package com.example.movieposters.interfaceApi;

import retrofit2.Call;
import retrofit2.http.GET;
import com.example.movieposters.model.FMovie;

public interface JSONHolder {

    @GET("/ajax/kinoafisha_load")
    Call<FMovie> getMovies();

}
