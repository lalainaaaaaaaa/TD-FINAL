package edu.soccer.app.dao.entity;

public class players {
    private String id;
    private String name;
    private int number;
    private String position;
    private String nationality;
    private int age;
    private clubs club; // Référence au club
    private IndividualStatistics individualStatistics;

    public players(String id, String name, int number, String position, String nationality, int age, clubs club, IndividualStatistics individualStatistics) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.position = position;
        this.nationality = nationality;
        this.age = age;
        this.club = club;
        this.individualStatistics = individualStatistics;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAge() {
        return age;
    }

    public clubs getClub() { // Méthode pour accéder à l'attribut club
        return club;
    }

    public IndividualStatistics getIndividualStatistics() {
        return individualStatistics;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", position='" + position + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", club=" + (club != null ? club.getName() : "None") +
                '}';
    }
}