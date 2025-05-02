package edu.soccer.app.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private final int year;
    private int label;
    private final List<Match> matches;
    private final List<Team> standings;


    public Season(int year) {
        this.year = year;
        this.label = label;
        this.matches = new ArrayList<>();
        this.standings = new ArrayList<>();
    }


    public List<Match> getMatches() {
        return matches;
    }


    public List<Team> getStandings() {
        return standings;
    }


    public int getYear() {
        return year;
    }

    public int getLabel() {
        return label;
    }


    public void generateMatches(List<Team> teams) {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team homeTeam = teams.get(i);
                Team awayTeam = teams.get(j);
                matches.add(new Match(homeTeam, awayTeam, this));
                matches.add(new Match(awayTeam, homeTeam, this));
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
        // Here, you can implement your logic to calculate standings based on match results (wins, losses, draws, etc.)
        // You could loop through the matches and update the teams' rankings accordingly.
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

    public int setMatches(List<Match> matches) {
        return 0;
    }

    public String getYearEnd() {
        return null;
    }
}
