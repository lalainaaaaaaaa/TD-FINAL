package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.clubs;

import java.util.ArrayList;
import java.util.List;

public class clubsCrudOperationsImpl implements clubsCrudOperations {
    private List<clubs> teams = new ArrayList<>();

    public clubsCrudOperationsImpl() {
        teams.add(new clubs("RMA"));
        teams.add(new clubs("FCB"));
        teams.add(new clubs("MCI"));
    }

    @Override
    public clubs getTeamByName(String name) {
        for (clubs team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        throw new IllegalArgumentException("Team not found: " + name);
    }

    @Override
    public List<clubs> findAll() {
        return new ArrayList<>(teams);
    }

    @Override
    public void addTeam(clubs team) {
        if (team.getName() == null || team.getName().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty.");
        }
        teams.add(team);
    }

    @Override
    public void updateTeam(clubs updatedTeam) {
        clubs existingTeam = getTeamByName(updatedTeam.getName());
        if (existingTeam != null) {
            existingTeam.setAcronym(updatedTeam.getAcronym());
        }
    }

    @Override
    public void deleteTeam(String name) {
        if (!teams.removeIf(team -> team.getName().equalsIgnoreCase(name))) {
            throw new IllegalArgumentException("Team not found: " + name);
        }
    }
}