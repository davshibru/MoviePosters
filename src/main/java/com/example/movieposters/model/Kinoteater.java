package com.example.movieposters.model;

public class Kinoteater {
    private String k_name;
    private String h_name;
    private String sessions;

    public Kinoteater(String k_name, String h_name, String sessions) {
        this.k_name = k_name;
        this.h_name = h_name;
        this.sessions = sessions;
    }

    public String getK_name() {
        return k_name;
    }

    public String getH_name() {
        return h_name;
    }

    public String getSessions() {
        return sessions;
    }
}
