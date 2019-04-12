package com.example.movieposters.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieposters.R;
import com.example.movieposters.model.ExpModel.KinoTeather;
import com.example.movieposters.model.ExpModel.Session_Zals_Time;
import com.example.movieposters.model.ModelForRecyclerView.SessionsForZal;
import com.example.movieposters.model.ModelForRecyclerView.Teathers;
import com.example.movieposters.model.ModelForRecyclerView.zalsNorm;
import com.example.movieposters.mvp.RecyclerViewAdapterMovie;

import java.util.ArrayList;
import java.util.List;

public class CinemaActivty extends AppCompatActivity implements Contracter.view {

    RecyclerView myRecyclerView;
    ImageView imageView;
    TextView textView;
    String Title;
    String Poster;
    String Vote;
    String Countries;
    String Actors;
    String Data;
    Model presentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_activty);


        Intent intent = getIntent();
        textView = (TextView) findViewById(R.id.movieInfo);
        imageView = (ImageView) findViewById(R.id.poster_in_cinema);
        presentor = new Model(this);
        Title = intent.getExtras().getString("Title");
        Poster = intent.getExtras().getString("Poster");
        Vote = intent.getExtras().getString("Vote");
        Countries = intent.getExtras().getString("Countries");
        Actors = intent.getExtras().getString("Actors");
        Data = intent.getExtras().getString("Data");

        presentor.ProcessData(Data, Poster, Actors);
    }



    public void Display(String HDPoster, ArrayList<KinoTeather> kinoTeathers, String ActorsNorm ){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Title);


        Glide.with(this)
                .asBitmap()
                .load(HDPoster)
                .into(imageView);

        textView.setText("Актеры: " + ActorsNorm + "\n\n" + "оценка фильма: " + Vote + "\n\n" + Countries);

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_cinema);
        RecyclerViewAdapterCinema recyclerViewAdapterCinema = new RecyclerViewAdapterCinema(kinoTeathers);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(recyclerViewAdapterCinema);
    }

}
