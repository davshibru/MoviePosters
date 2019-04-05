package com.example.movieposters.model;

import java.util.List;

public class FMovie {
    private boolean succes;
    private int count;
    private List<Movie> result;

    public FMovie(boolean succes, int count, List<Movie> result) {
        this.succes = succes;
        this.count = count;
        this.result = result;
    }

    public boolean getSucces() {
        return succes;
    }

    public int getCount() {
        return count;
    }

    public List<Movie> getResult() {
        return result;
    }
}
