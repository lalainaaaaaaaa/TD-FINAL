package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.Season;
import edu.soccer.app.repository.SeasonRepository;

import java.sql.SQLException;
import java.util.List;

public class SeasonService {
    private final SeasonRepository seasonRepository;

    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public List<Season> findAll() {
        try {
            return seasonRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving seasons", e);
        }
    }

    public void save(Season season) {
        try {
            seasonRepository.save(season);
        } catch (SQLException e) {
            throw new RuntimeException("Error saving season", e);
        }
    }

    public void update(Season season) {
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