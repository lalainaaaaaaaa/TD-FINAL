package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class season {
    private final int year;
    private int label;
    private final List<edu.soccer.app.dao.entity.matches> matches;
    private final List<clubs> standings;

    public season(int year) {
        this.year = year;
        this.label = year;
        this.matches = new ArrayList<>();
        this.standings = new ArrayList<>();
    }

    public List<edu.soccer.app.dao.entity.matches> getMatches() {
        return matches;
    }

    public List<clubs> getStandings() {
        return standings;
    }

    public int getYear() {
        return year;
    }

    public int getLabel() {
        return label;
    }

    public void generateMatches(List<clubs> teams) {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                clubs homeTeam = teams.get(i);
                clubs awayTeam = teams.get(j);
                matches.add(new matches(homeTeam, awayTeam, this));
                matches.add(new matches(awayTeam, homeTeam, this));
            }
        }
    }

    // Method to end the season and calculate standings
    public void endSeason() {
        calculateStandings();
        System.out.println("The season " + year + " has ended.");
    }

    // Logic to calculate standings based on match results
    private void calculateStandings() {
        standings.clear();
        // Implement the logic for calculating standings based on match results (wins, losses, draws, etc.)
    }

    // Overridden toString method to represent the season's information
    @Override
    public String toString() {
        return "Season{" +
                "year=" + year +
                ", label='" + label + '\'' +
                ", matches=" + matches.size() +
                " matches, standings=" + standings.size() + " teams" +
                '}';
    }

    public void setMatches(List<edu.soccer.app.dao.entity.matches> matches) {
        this.matches.clear();
        this.matches.addAll(matches);
    }

    public String getYearEnd() {
        return Integer.toString(year);
    }
}