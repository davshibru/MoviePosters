package com.example.movieposters.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.movieposters.R;
import com.example.movieposters.model.ModelForRecyclerView.PoserAndTitle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contracter.view{

    private String BaseUrl = "http://kinoafisha.ua";
    private Model presentor;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presentor = new Model(this);
        textView = (TextView) findViewById(R.id.textView);
        presentor.getDataFromSite(BaseUrl);
    }

    @Override
    public void setRecyclerViev(List<PoserAndTitle> movie) {
//        textView.setText(movie);
        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerViewAdapterMovie myAdapter = new RecyclerViewAdapterMovie(this, movie);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);
    }
}
