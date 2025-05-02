package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.Bestclubs;

import java.util.ArrayList;
import java.util.List;

public class BestclubsCrudOperationsImpl implements BestclubsCrudOperations {
    private static List<clubs> teams = new ArrayList<>();

    @Override
    public void addTeam(clubs team) {
        teams.add(team);
    }

    @Override
    public clubs getTeamByName(String name) {
        for (clubs team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }

    @Override
    public void updateTeam(clubs updatedTeam) {
        clubs existingTeam = getTeamByName(updatedTeam.getName());
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
    public clubs getBestTeam() {
        return Bestclubs.bestTeam(teams);
    }

    @Override
    public List<clubs> findAll() {
        return new ArrayList<>(teams);
    }
}
