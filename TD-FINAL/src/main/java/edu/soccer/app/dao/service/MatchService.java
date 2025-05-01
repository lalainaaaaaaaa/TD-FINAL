package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.repository.MatchRepository;

import java.sql.SQLException;
import java.util.List;

public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> findAll() {
        try {
            return matchRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving matches", e);
        }
    }

    public void save(Match match) {
        matchRepository.save(match);
    }
}