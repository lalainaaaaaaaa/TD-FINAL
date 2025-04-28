package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class Championship {
    private String name;
    private String country;
    private List<Team> teams;
    private Season currentSeason;

    public Championship(String name, String country) {
        this.name = name;
        this.country = country;
        this.teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void generateMatches() {
        // Logic to generate matches for the current season
    }

    public void endSeason() {
        // Logic to end the season
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(Season currentSeason) {
        this.currentSeason = currentSeason;
    }
}
