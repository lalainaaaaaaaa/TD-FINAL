package edu.soccer.app.dao.entity;

public class players {
    private String name;
    private int number;
    private String position;
    private String nationality;
    private int age;

    private IndividualStatistics individualStatistics;

    private clubs club;

    public players(String name, int number, String position, String nationality, int age) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.nationality = nationality;
        this.age = age;
        this.individualStatistics = new IndividualStatistics();
    }


    public clubs getClub() {
        return club;
    }

    public void setClub(clubs club) {
        this.club = club;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public Integer getId() {
        return number;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAge() {
        return age;
    }

    public IndividualStatistics getIndividualStatistics() {
        return individualStatistics;
    }

    public void setIndividualStatistics(IndividualStatistics stats) {
        this.individualStatistics = stats;
    }

    public void updatePosition(String position) {
        this.position = position;
    }

    public void updateNationality(String nationality) {
        this.nationality = nationality;
    }

    public void updateAge(int age) {
        this.age = age;
    }
}
