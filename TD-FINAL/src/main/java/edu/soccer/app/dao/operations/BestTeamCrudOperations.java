package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.entity.BestTeam;

import java.util.ArrayList;
import java.util.List;

public class BestTeamCrudOperations {

    private static List<Team> teams = new ArrayList<>();

    public static void addTeam(Team team) {
        teams.add(team);
    }

    public static Team getTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }

    public static void updateTeam(Team updatedTeam) {
        Team existingTeam = getTeamByName(updatedTeam.getName());
        if (existingTeam != null) {
            existingTeam.setStadium(updatedTeam.getStadium());
            existingTeam.setPoints(updatedTeam.getPoints());
            existingTeam.setAcronym(updatedTeam.getAcronym());
            existingTeam.setYearFounded(updatedTeam.getYearFounded());
            existingTeam.setStatistics(updatedTeam.getStatistics());
        }
    }

    public static void deleteTeam(String name) {
        teams.removeIf(team -> team.getName().equalsIgnoreCase(name));
    }

    public static Team getBestTeam() {
        return BestTeam.bestTeam(teams);
    }

    public static List<Team> findAll() {
        return new ArrayList<>(teams);
    }
}
