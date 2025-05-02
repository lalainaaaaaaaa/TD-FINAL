package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.season;

import java.sql.SQLException;
import java.util.List;

public class seasonService {
    private final edu.soccer.app.repository.seasonRepository seasonRepository;

    public seasonService(edu.soccer.app.repository.seasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public List<season> findAll() {
        try {
            return seasonRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving seasons", e);
        }
    }

    public void save(season season) {
        // Validation des données
        if (season.getYear() <= 0) {
            throw new IllegalArgumentException("Season year must be greater than zero.");
        }
        try {
            seasonRepository.save(season);
        } catch (SQLException e) {
            throw new RuntimeException("Error saving season", e);
        }
    }

    public void update(season season) {
        try {
            seasonRepository.update(season);
        } catch (SQLException e) {
            throw new RuntimeException("Error updating season", e);
        }
    }

    public void delete(int year) {
        try {
            seasonRepository.delete(year);
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting season", e);
        }
    }
}