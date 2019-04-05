package com.example.movieposters.model.ModelForRecyclerView;

import java.util.List;

public class Zal {

    private String zal;
    private List<SessionsForZal> sessions;
    private String teather;

    public Zal(String zal, List<SessionsForZal> sessions, String teather) {
        this.zal = zal;
        this.sessions = sessions;
        this.teather = teather;
    }

    public String getZal() {
        return zal;
    }

    public List<SessionsForZal> getSessions() {
        return sessions;
    }

    public String getTeather() {
        return teather;
    }
}
