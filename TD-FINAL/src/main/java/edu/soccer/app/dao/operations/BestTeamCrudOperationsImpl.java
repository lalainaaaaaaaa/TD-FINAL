package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.entity.BestTeam;

import java.util.ArrayList;
import java.util.List;

public class BestTeamCrudOperationsImpl implements BestTeamCrudOperations {
    private static List<Team> teams = new ArrayList<>();

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public Team getTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }

    @Override
    public void updateTeam(Team updatedTeam) {
        Team existingTeam = getTeamByName(updatedTeam.getName());
        if (existingTeam != null) {
            existingTeam.setStadium(updatedTeam.getStadium());
            existingTeam.setPoints(updatedTeam.getPoints());
            existingTeam.setAcronym(updatedTeam.getAcronym());
            existingTeam.setYearFounded(updatedTeam.getYearFounded());
            existingTeam.setStatistics(updatedTeam.getStatistics());
        }
    }

    @Override
    public void deleteTeam(String name) {
        teams.removeIf(team -> team.getName().equalsIgnoreCase(name));
    }

    @Override
    public Team getBestTeam() {
        return BestTeam.bestTeam(teams);
    }

    @Override
    public List<Team> findAll() {
        return new ArrayList<>(teams);
    }
}
