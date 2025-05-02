package edu.soccer.app.dao.entity;

public class clubs {
    private String name;
    private String stadium;               // Stadium name
    private String acronym;               // Acronym (e.g., "RMA", "FCB")
    private int yearFounded;              // Year founded
    private int points;                   // Points for the current season
    private CollectiveStatistics statistics; // Collective statistics

    // Main constructor
    public clubs(String name) {
        this.name = name;
        this.stadium = "";
        this.acronym = "";
        this.yearFounded = 0;
        this.points = 0; // Initialize to 0 at the start of the season
        this.statistics = new CollectiveStatistics(); // Empty statistics at start
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getStadium() {
        return stadium;
    }

    public String getAcronym() {
        return acronym;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public int getPoints() {
        return points;
    }

    public CollectiveStatistics getStatistics() {
        return statistics;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setStatistics(CollectiveStatistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", stadium='" + stadium + '\'' +
                ", acronym='" + acronym + '\'' +
                ", yearFounded=" + yearFounded +
                ", points=" + points +
                ", statistics=" + statistics +
                '}';
    }
}