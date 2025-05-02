package edu.soccer.app.dao.entity;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private Season season;
    private int homeScore;
    private int awayScore;

    // Constructor to initialize the match with teams and season
    public Match(Team homeTeam, Team awayTeam, Season season) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.season = season;
        this.homeScore = 0;  // Default score
        this.awayScore = 0;  // Default score
    }

    // Getter and Setter methods
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    // Method to simulate the match by setting the scores
    public void play(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeTeam=" + homeTeam.getName() +
                ", awayTeam=" + awayTeam.getName() +
                ", season=" + season.getLabel() +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                '}';
    }

    public String getDateTime() {
        return null;
    }

    public String getStadium() {
        return null;
    }
}
