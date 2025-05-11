package edu.soccer.app.dao.entity;

public class players {
    private String id;
    private String name;
    private int number;
    private int age;
    private String position;
    private String nationality;
    private int playingTimeSeconds;
    private clubs club;
    private IndividualStatistics individualStatistics;

    public players(String id, String name, int number, int age, String position, String nationality, int playingTimeSeconds, clubs club) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.age = age;
        this.position = position;
        this.nationality = nationality;
        this.playingTimeSeconds = playingTimeSeconds;
        this.club = club;
        this.individualStatistics = new IndividualStatistics();
    }


    public String getId() { return id; }
    public String getName() { return name; }
    public int getNumber() { return number; }
    public int getAge() { return age; }
    public String getPosition() { return position; }
    public String getNationality() { return nationality; }
    public int getPlayingTimeSeconds() { return playingTimeSeconds; }
    public clubs getClub() { return club; }
    public IndividualStatistics getIndividualStatistics() { return individualStatistics; }


    public void setId(String id) {
        this.id = id;
    }

    public void setIndividualStatistics(IndividualStatistics stats) {
        this.individualStatistics = stats;
    }
}
