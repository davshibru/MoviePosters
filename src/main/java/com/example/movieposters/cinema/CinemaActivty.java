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

public class CinemaActivty extends AppCompatActivity {

    RecyclerView myRecyclerView;
    List<SessionsForZal> sessionsForZals;
    List<zalsNorm> zalsNorms;
    List<Teathers> teathers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_activty);


        Intent intent = getIntent();
        ImageView imageView = (ImageView) findViewById(R.id.poster_in_cinema);
        String Title = intent.getExtras().getString("Title");
        String Poster = intent.getExtras().getString("Poster");
        String Data = intent.getExtras().getString("Data");

//        List<Teathers> lstTeath = sort(Data);

        Log.e("teather", "check");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Title);
        String HDPoster = MakeNormalImg(Poster);

        Glide.with(this)
                .asBitmap()
                .load(HDPoster)
                .into(imageView);


        ArrayList<KinoTeather> kinoTeathers = sort(Data);

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_cinema);
        RecyclerViewAdapterCinema recyclerViewAdapterCinema = new RecyclerViewAdapterCinema(kinoTeathers);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(recyclerViewAdapterCinema);

    }

    public String MakeNormalImg(String img){
        String[] image = img.split("sm_");
        img = image[0] + image[1];
        return img;
    }

    public ArrayList<KinoTeather> sort(String Data){
        ArrayList<KinoTeather> kinoTeathers = new ArrayList<>();

        String[] str = Data.split("razdelitkinoteather");
        for (String string : str){
            if (!string.equals("")) {
                String[] zals = string.split("razdelitzal");
                ArrayList<Session_Zals_Time> session_zals_times = new ArrayList<>();
                for (int i = 2; i < zals.length; i++) {

                    String sessiansAndZals = "";
                    String[] seans = zals[i].split("razdelitvremi");
                    sessiansAndZals += seans[0] + ":" + "\n";

                    for (int j = 1; j < seans.length; j++ ) {
                        sessiansAndZals += seans[j] + "\n";
                    }
                    session_zals_times.add(new Session_Zals_Time(sessiansAndZals));
                }
                KinoTeather kinoTeather = new KinoTeather(zals[1], session_zals_times);
                kinoTeathers.add(kinoTeather);
            }
        }

        return kinoTeathers;
    }
}
