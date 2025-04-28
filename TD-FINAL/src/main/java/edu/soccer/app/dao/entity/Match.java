package edu.soccer.app.dao.entity;

import java.time.LocalDateTime;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private LocalDateTime dateTime;
    private String stadium;
    private Season season;

    public Match(Team homeTeam, Team awayTeam, LocalDateTime dateTime, String stadium, Season season) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.dateTime = dateTime;
        this.stadium = stadium;
        this.season = season;
    }

    public void play() {
        // Logic to play the match
    }

    public String getResult() {
        // Logic to return the match result
        return null;
    }

    // Getters and setters
    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getStadium() {
        return stadium;
    }

    public Season getSeason() {
        return season;
    }
}