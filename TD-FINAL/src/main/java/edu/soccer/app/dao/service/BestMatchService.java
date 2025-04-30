package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.repository.BestMatchRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class BestMatchService {
    private final BestMatchRepository bestMatchRepository;


    public BestMatchService(Connection connection) {
        this.bestMatchRepository = new BestMatchRepository(connection);
    }

    public List<Match> getAllMatches() throws SQLException {
        return bestMatchRepository.findAll();
    }

    public Match getBestMatch() throws SQLException {
        return bestMatchRepository.getBestMatch();
    }

    public List<Match> getMatchesBySeason(String seasonYear) throws SQLException {
        List<Match> allMatches = bestMatchRepository.findAll();

        return allMatches.stream()
                .filter(match -> String.valueOf(match.getSeason().getYear()).equals(seasonYear)) // Compare comme String
                .collect(Collectors.toList());
    }
}
