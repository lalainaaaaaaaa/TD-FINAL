package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.championships;
import edu.soccer.app.dao.entity.players;
import edu.soccer.app.repository.championshipsRepository;

import java.sql.SQLException;
import java.util.List;

public abstract class championshipsService {
    private championshipsRepository championshipRepository;

    public championshipsService() {
        this.championshipRepository = championshipRepository;
    }

    public List<championships> findAll() {
        try {
            return championshipRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving championships", e);
        }
    }

    public void save(championships championship) {
        if (championship.getName() == null || championship.getName().isEmpty()) {
            throw new IllegalArgumentException("Championship name cannot be null or empty.");
        }
        try {
            championshipRepository.save(championship);
        } catch (SQLException e) {
            throw new RuntimeException("Error saving championship", e);
        }
    }

    public abstract String synchronize(String apiKey);

    public abstract List<players> getBestPlayers();
}