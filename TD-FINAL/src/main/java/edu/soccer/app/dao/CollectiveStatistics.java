package edu.soccer.app.dao.entity;

public class CollectiveStatistics {
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int cleanSheets;

    public CollectiveStatistics() {
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.cleanSheets = 0;
    }

    public void update(int goalsFor, int goalsAgainst) {
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
        if (goalsFor > goalsAgainst) {
            this.points += 3;
        } else if (goalsFor == goalsAgainst) {
            this.points += 1;
        }
        if (goalsAgainst == 0) {
            this.cleanSheets++;
        }
    }

    public int getPoints() {
        return points;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }
}