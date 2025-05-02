package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.repository.playersRepository;

import java.sql.SQLException;
import java.util.List;

public class playersService {
    private final playersRepository playerRepository;

    public playersService(playersRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<players> findAll() {
        try {
            return playerRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving players", e);
        }
    }

    public void save(players player) {
        if (player.getName() == null || player.getName().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }
        try {
            playerRepository.save(player);
        } catch (SQLException e) {
            throw new RuntimeException("Error saving player", e);
        }
    }
}