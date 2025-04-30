package edu.soccer.app.dao.entity;

public class Player {
    private String name;
    private int number;
    private String position;
    private String nationality;
    private int age;
    private IndividualStatistics individualStatistics;


    public Player(String name, int number, String position, String nationality, int age, IndividualStatistics stats) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.nationality = nationality;
        this.age = age;
        this.individualStatistics = (stats != null) ? stats : new IndividualStatistics();
    }

    public Player(String name, int number, String position, String nationality, int age) {
        this(name, number, position, nationality, age, null);
    }

    public Player(String name, String position, String nationality) {
        this.name = name;
        this.position = position;
        this.nationality = nationality;
        this.number = 0;
        this.age = 0;
        this.individualStatistics = new IndividualStatistics();
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

    public IndividualStatistics getIndividualStatistics() {
        return individualStatistics;
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