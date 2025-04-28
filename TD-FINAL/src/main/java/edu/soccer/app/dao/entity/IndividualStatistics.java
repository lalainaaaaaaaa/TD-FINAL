package edu.soccer.app.dao.entity;

public class IndividualStatistics {
    private int goalsScored;
    private int playingTime;

    public void updateGoals() {
        goalsScored++;
    }

    public void updatePlayingTime(int minutes) {
        playingTime += minutes;
    }

    // Getters and setters
    public int getGoalsScored() {
        return goalsScored;
    }

    public int getPlayingTime() {
        return playingTime;
    }
}
