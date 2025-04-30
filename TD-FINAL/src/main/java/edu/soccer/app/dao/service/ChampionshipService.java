package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.Championship;
import edu.soccer.app.repository.ChampionshipRepository;

import java.sql.SQLException;
import java.util.List;

public class ChampionshipService {
    private final ChampionshipRepository championshipRepository;

    public ChampionshipService(ChampionshipRepository championshipRepository) {
        this.championshipRepository = championshipRepository;
    }

    public List<Championship> findAll() {
        try {
            return championshipRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving championships", e);
        }
    }

    public void save(Championship championship) {
        try {
            championshipRepository.save(championship);
        } catch (SQLException e) {
            throw new RuntimeException("Error saving championship", e);
        }
    }
}