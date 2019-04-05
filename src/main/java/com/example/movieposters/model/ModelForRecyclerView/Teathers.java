package com.example.movieposters.model.ModelForRecyclerView;

import java.util.List;

public class Teathers {
    private String teathers;
    List<zalsNorm> zals;

    public Teathers(String teathers, List<zalsNorm> zals) {
        this.teathers = teathers;
        this.zals = zals;
    }

    public String getTeathers() {
        return teathers;
    }

    public List<zalsNorm> getZals() {
        return zals;
    }
}
