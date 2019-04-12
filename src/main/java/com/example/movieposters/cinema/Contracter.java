package com.example.movieposters.cinema;

import com.example.movieposters.model.ExpModel.KinoTeather;
import com.example.movieposters.model.ModelForRecyclerView.PoserAndTitle;

import java.util.ArrayList;
import java.util.List;

public interface Contracter {
    interface model {
        void ProcessData(String Data, String Poster, String Actors);
    }

    interface view {
        void Display(String HDPoster, ArrayList<KinoTeather> kinoTeathers, String ActorsNorm );
    }
}
