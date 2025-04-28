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
        // Logic to generate matches for the season
    }

    public List<Team> getStandings() {
        return standings;
    }

    // Getters and setters
    public int getYear() {
        return year;
    }

    public List<Match> getMatches() {
        return matches;
    }
}
