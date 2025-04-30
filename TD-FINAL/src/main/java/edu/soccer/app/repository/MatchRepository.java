package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Team;

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
        String sql = "SELECT * FROM Match";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Team homeTeam = new Team(null, "Santiago Bernabeu", rs.getString("homeTeam"), null); // Remplacer null par l'acronyme et l'année
                Team awayTeam = new Team(null, "Santiago Bernabeu", rs.getString("awayTeam"), null); // Remplacer null par l'acronyme et l'année

                Match match = new Match(homeTeam, awayTeam, null);
                matches.add(match);
            }
        }
        return matches;
    }

    public void save(Match match) throws SQLException {
        String sql = "INSERT INTO Match (homeTeam, awayTeam, dateTime, stadium, season) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, match.getHomeTeam().getName());
            pstmt.setString(2, match.getAwayTeam().getName());
            pstmt.setTimestamp(3, Timestamp.valueOf(match.getDateTime()));
            pstmt.setString(4, match.getStadium());
            pstmt.setInt(5, match.getSeason().getYear()); // Correction pour passer un entier
            pstmt.executeUpdate();
        }
    }

    public void update(Match match) throws SQLException {
        String sql = "UPDATE Match SET dateTime = ?, stadium = ? WHERE homeTeam = ? AND awayTeam = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setTimestamp(1, Timestamp.valueOf(match.getDateTime()));
            pstmt.setString(2, match.getStadium());
            pstmt.setString(3, match.getHomeTeam().getName());
            pstmt.setString(4, match.getAwayTeam().getName());
            pstmt.executeUpdate();
        }
    }

    public void delete(String homeTeam, String awayTeam) throws SQLException {
        String sql = "DELETE FROM Match WHERE homeTeam = ? AND awayTeam = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, homeTeam);
            pstmt.setString(2, awayTeam);
            pstmt.executeUpdate();
        }
    }
}