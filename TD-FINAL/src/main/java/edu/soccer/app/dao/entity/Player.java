package edu.soccer.app.dao.entity;


public class Player {
    private final String name;
    private final int number;
    private final String position;
    private final String nationality;
    private final int age;
    private final IndividualStatistics individualStatistics;

    public Player(String name, int number, String position, String nationality, int age) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.nationality = nationality;
        this.age = age;
        this.individualStatistics = new IndividualStatistics();
    }

    public void scoreGoal() {
        individualStatistics.updateGoals();
    }

    public void playMatch(int minutes) {
        individualStatistics.updatePlayingTime(minutes);
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

}
