package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.repository.playersRepository;

import java.sql.SQLException;
import java.util.List;

public abstract class playersService {
    private playersRepository playerRepository;

    public playersService() {
        this.playerRepository = playerRepository;
    }

    public static List<players> getBestplayers(int top, String playingTimeUnit) {
        return null;
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

    public abstract List<players> getBestPlayers(int top, String playingTimeUnit);
}