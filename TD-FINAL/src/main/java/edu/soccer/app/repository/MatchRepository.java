package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.Match;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchRepository {
    private final Connection connection;

    public MatchRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Match> findAll() throws SQLException {
        List<Match> matches = new ArrayList<>();
        String sql = "SELECT * FROM matches";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Match match = new Match();
                matches.add(match);
            }
        }
        return matches;
    }

    public void save(Match match) throws SQLException {
        String sql = "INSERT INTO matches (homeTeam, awayTeam, dateTime, stadium, season) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, match.getHomeTeam().getName());
            pstmt.setString(2, match.getAwayTeam().getName());
            pstmt.setTimestamp(3, Timestamp.valueOf(match.getDateTime()));
            pstmt.setString(4, match.getStadium());
            pstmt.setString(5, match.getSeason().getYear());
            pstmt.executeUpdate();
        }
    }

    public void update(Match match) throws SQLException {
        String sql = "UPDATE matches SET dateTime = ?, stadium = ? WHERE homeTeam = ? AND awayTeam = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setTimestamp(1, Timestamp.valueOf(match.getDateTime()));
            pstmt.setString(2, match.getStadium());
            pstmt.setString(3, match.getHomeTeam().getName());
            pstmt.setString(4, match.getAwayTeam().getName());
            pstmt.executeUpdate();
        }
    }

    public void delete(String homeTeam, String awayTeam) throws SQLException {
        String sql = "DELETE FROM matches WHERE homeTeam = ? AND awayTeam = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, homeTeam);
            pstmt.setString(2, awayTeam);
            pstmt.executeUpdate();
        }
    }
}