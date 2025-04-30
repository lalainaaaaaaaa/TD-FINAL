package edu.soccer.app.dao.entity;

public class Team {
    private String name;
    private String stadium;
    private String acronym;
    private int yearFounded;
    private int points;
    private CollectiveStatistics statistics;


    public Team(String name) {
        this.name = name;
        this.stadium = stadium;
        this.acronym = acronym;
        this.yearFounded = yearFounded;
        this.points = points;
        this.statistics = statistics != null ? statistics : new CollectiveStatistics();
    }


    public Team(String name, String acronym, int yearFounded, String stadium) {
        this(name);
    }


    public Team(String o, String santiagoBernabeu, String name, String stadium) {
        this(name);
    }


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
