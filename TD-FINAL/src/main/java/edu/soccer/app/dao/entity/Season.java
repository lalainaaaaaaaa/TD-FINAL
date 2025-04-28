package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private int year;
    private List<Match> matches;
    private List<Team> standings;

    public Season(int year) {
        this.year = year;
        this.matches = new ArrayList<>();
        this.standings = new ArrayList<>();
    }

    public void generateMatches() {
        // Logic
    }

    public List<Team> getStandings() {
        return standings;
    }

    public String getYear() {
        return String.valueOf(year);
    }

    public List<Match> getMatches() {
        return matches;
    }
}
