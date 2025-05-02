package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.matchMaker;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class matchMakerRepository {
    private Connection connection;

    public matchMakerRepository(Connection connection) {
        this.connection = connection;
    }

    public List<matches> findAll() throws SQLException {
        List<matches> matches = new ArrayList<>();
        String sql = "SELECT * FROM Match";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                clubs homeTeam = findTeamByName(rs.getString("home_team"));
                clubs awayTeam = findTeamByName(rs.getString("away_team"));
                season season = findSeasonById(rs.getInt("season_id"));

                edu.soccer.app.dao.entity.matches match = new matches(homeTeam, awayTeam, season);
                match.play(rs.getInt("home_score"), rs.getInt("away_score"));
                matches.add(match);
            }
        }

        return matches;
    }

    public matches getBestMatch() throws SQLException {
        List<matches> matches = findAll();
        return matchMaker.bestMatch(matches);
    }

    private clubs findTeamByName(String name) throws SQLException {
        String sql = "SELECT * FROM Team WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new clubs(rs.getString("name")); // Ajuster selon vos propriétés
                }
            }
        }
        throw new SQLException("Team not found: " + name);
    }

    private season findSeasonById(int id) throws SQLException {
        String sql = "SELECT * FROM Season WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new season(rs.getInt("id")); // Ajuster selon vos propriétés
                }
            }
        }
        throw new SQLException("Season not found with id: " + id);
    }
}