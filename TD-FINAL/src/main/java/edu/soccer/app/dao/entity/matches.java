package edu.soccer.app.dao.entity;

public class matches {
    private clubs homeTeam;
    private clubs awayTeam;
    private edu.soccer.app.dao.entity.season season;
    private int homeScore;
    private int awayScore;


    public matches(clubs homeTeam, clubs awayTeam, edu.soccer.app.dao.entity.season season) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.season = season;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public clubs getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(clubs homeTeam) {
        this.homeTeam = homeTeam;
    }

    public clubs getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(clubs awayTeam) {
        this.awayTeam = awayTeam;
    }

    public edu.soccer.app.dao.entity.season getSeason() {
        return season;
    }

    public void setSeason(edu.soccer.app.dao.entity.season season) {
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