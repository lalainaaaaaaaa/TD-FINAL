package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamCrudOperationsImpl implements TeamCrudOperations {
    private List<Team> teams = new ArrayList<>();

    public TeamCrudOperationsImpl() {
        teams.add(new Team("RMA"));
        teams.add(new Team("FCB"));
        teams.add(new Team("MCI"));
    }

    @Override
    public Team getTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        throw new IllegalArgumentException("Team not found: " + name);
    }

    @Override
    public List<Team> findAll() {
        return new ArrayList<>(teams);
    }

    @Override
    public void addTeam(Team team) {
        if (team.getName() == null || team.getName().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty.");
        }
        teams.add(team);
    }

    @Override
    public void updateTeam(Team updatedTeam) {
        Team existingTeam = getTeamByName(updatedTeam.getName());
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