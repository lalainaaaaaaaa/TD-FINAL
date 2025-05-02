package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.repository.clubsRepository;

import java.sql.SQLException;
import java.util.List;

public class clubsService {
    private final clubsRepository teamRepository;

    public clubsService(clubsRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<clubs> findAll() {
        try {
            return teamRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving teams", e);
        }
    }

    public void save(clubs team) {
        if (team.getName() == null || team.getName().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty.");
        }
        try {
            teamRepository.save(team);
        } catch (SQLException e) {
            throw new RuntimeException("Error saving team", e);
        }
    }
}