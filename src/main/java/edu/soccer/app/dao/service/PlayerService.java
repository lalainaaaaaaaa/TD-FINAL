package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.Player;
import edu.soccer.app.repository.PlayerRepository;

import java.sql.SQLException;
import java.util.List;

public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        try {
            return playerRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving players", e);
        }
    }

    public void save(Player player) {
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