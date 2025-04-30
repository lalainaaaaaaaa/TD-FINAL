package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.repository.TeamRepository;

import java.sql.SQLException;
import java.util.List;

public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAll() {
        try {
            return teamRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving teams", e);
        }
    }

    public void save(Team team) {
        try {
            teamRepository.save(team);
        } catch (SQLException e) {
            throw new RuntimeException("Error saving team", e);
        }
    }
}