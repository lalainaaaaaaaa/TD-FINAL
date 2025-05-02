package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.repository.matchesRepository;

import java.sql.SQLException;
import java.util.List;

public class matchesService {
    private final matchesRepository matchRepository;

    public matchesService(matchesRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<matches> findAll() {
        try {
            return matchRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving matches", e);
        }
    }

    public void save(matches match) {
        matchRepository.save(match);
    }
}