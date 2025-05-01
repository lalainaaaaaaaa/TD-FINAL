package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.BestMatch;
import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Season;
import edu.soccer.app.dao.entity.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BestMatchRepository {
    private final Connection connection;

    public BestMatchRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Match> findAll() throws SQLException {
        List<Match> matches = new ArrayList<>();
        String sql = "SELECT * FROM Match";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Team homeTeam = findTeamByName(rs.getString("home_team"));
                Team awayTeam = findTeamByName(rs.getString("away_team"));
                Season season = findSeasonById(rs.getInt("season_id"));

                Match match = new Match(homeTeam, awayTeam, season);
                match.play(rs.getInt("home_score"), rs.getInt("away_score"));
                matches.add(match);
            }
        }

        return matches;
    }

    public Match getBestMatch() throws SQLException {
        List<Match> matches = findAll();
        return BestMatch.bestMatch(matches);
    }

    private Team findTeamByName(String name) throws SQLException {
        String sql = "SELECT * FROM Team WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Team(rs.getString("name")); // Ajuster selon vos propriétés
                }
            }
        }
        throw new SQLException("Team not found: " + name);
    }

    private Season findSeasonById(int id) throws SQLException {
        String sql = "SELECT * FROM Season WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Season(rs.getInt("id")); // Ajuster selon vos propriétés
                }
            }
        }
        throw new SQLException("Season not found with id: " + id);
    }
}