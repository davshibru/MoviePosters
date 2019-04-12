package com.example.movieposters.mvp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieposters.R;
import com.example.movieposters.interfaceApi.JSONHolder;
import com.example.movieposters.model.FMovie;
import com.example.movieposters.model.Kinoteater;
import com.example.movieposters.model.ModelForRecyclerView.PoserAndTitle;
import com.example.movieposters.model.ModelForRecyclerView.SessionsForZal;
import com.example.movieposters.model.ModelForRecyclerView.Zal;
import com.example.movieposters.model.Movie;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class Model implements Contracter.model{

    private final Contracter.view view;

    public Model(Contracter.view view) {
        this.view = view;
    }

    public void getDataFromSite(String BaseUrl){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONHolder jsonHolder = retrofit.create(JSONHolder.class);

        Call<FMovie> call = jsonHolder.getMovies();

        call.enqueue(new Callback<FMovie>() {
            @Override
            public void onResponse(Call<FMovie> call, Response<FMovie> response) {
                List<PoserAndTitle> movieData = new ArrayList<>();
                FMovie fmovie = response.body();

                List<Movie> movies = fmovie.getResult();
                for (Movie movie : movies) {

                    List<Kinoteater> kinoteaters = movie.getSessions();
                    List<Zal> Zals = new ArrayList<>();
                    String teather = "";

                    for (Kinoteater kinoteater : kinoteaters) {
                        if (kinoteater.getK_name() != null){
                            teather = kinoteater.getK_name();
                        }
                        Zals.add(new Zal(kinoteater.getH_name(), getSession(kinoteater.getSessions()), teather)) ;
                    }

                    movieData.add(new PoserAndTitle(movie.getName(),movie.getImage(), Zals, movie.getVote(), movie.getCountries(), movie.getActors()));

                }
                view.setRecyclerViev(movieData);
            }
                @Override
                public void onFailure(Call<FMovie> call, Throwable t) {
//                    textView.setText("prob");
                }
            });
        }

        private static List<SessionsForZal> getSession(String session){
            List<SessionsForZal> sessionsForZals = new ArrayList<>();
            String answer = "";
            for (int i = 0; i < session.length(); i++){
                if(isInt("" + session.charAt(i))){
                    if (isInt("" + session.charAt(i + 1)) && ("" + session.charAt(i + 2)).equals(":") ){
                        sessionsForZals.add(new SessionsForZal("" + session.charAt(i) + session.charAt(i + 1) + session.charAt(i + 2) + session.charAt(i + 3) + session.charAt(i + 4)));
                        i = i + 5;
                    }
                }
            }
            return sessionsForZals;
        }

        private static boolean isInt(String str){
            boolean isOrNot = false;
            for (int i = 0; i < 10; i++){
                if ((i + "").equals(str)){
                    isOrNot = true;
                }
            }
            return isOrNot;
        }
}
