package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamCrudOperations {
    private static List<Team> teams = new ArrayList<>();

    static {
        teams.add(new Team("Real Madrid FC", "RMA", 1902, "Santiago Bernabeu"));
        teams.add(new Team("FC Barcelone", "FCB", 1899, "Lluís Companys"));
        teams.add(new Team("Manchester City", "MCI", 1880, "Etihad Stadium"));
    }

    public static Team getTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }

    public static List<Team> findAll() {
        return new ArrayList<>(teams);
    }

    public static void addTeam(Team team) {
        teams.add(team);
    }

    public static void updateTeam(Team updatedTeam) {
        Team existingTeam = getTeamByName(updatedTeam.getName());
        if (existingTeam != null) {
            existingTeam.setAcronym(updatedTeam.getAcronym());
        }
    }

    public static void deleteTeam(String name) {
        teams.removeIf(team -> team.getName().equalsIgnoreCase(name));
    }
}