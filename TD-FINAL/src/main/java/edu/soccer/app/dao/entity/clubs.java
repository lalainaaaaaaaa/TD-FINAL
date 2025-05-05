package edu.soccer.app.dao.entity;

public class clubs {
    private int id;
    private String name;
    private String stadium;
    private String acronym;
    private int yearFounded;
    private int points;
    private CollectiveStatistics statistics;


    public clubs(String name) {
        this.id = id;
        this.name = name;
        this.stadium = "";
        this.acronym = "";
        this.yearFounded = 0;
        this.points = 0;
        this.statistics = new CollectiveStatistics();
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", stadium='" + stadium + '\'' +
                ", acronym='" + acronym + '\'' +
                ", yearFounded=" + yearFounded +
                ", points=" + points +
                ", statistics=" + statistics +
                '}';
    }
}
