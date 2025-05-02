package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.repository.matchMakerRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class matchMakerService {
    private final matchMakerRepository matchMakerRepository;


    public matchMakerService(Connection connection) {
        this.matchMakerRepository = new matchMakerRepository (connection);
    }

    public List<matches> getAllMatches() throws SQLException {
        return matchMakerRepository .findAll();
    }

    public matches getBestMatch() throws SQLException {
        return matchMakerRepository.getBestMatch();
    }

    public List<matches> getMatchesBySeason(String seasonYear) throws SQLException {
        List<matches> allMatches = matchMakerRepository.findAll();

        return allMatches.stream()
                .filter(match -> String.valueOf(match.getSeason().getYear()).equals(seasonYear))
                .collect(Collectors.toList());
    }
}
