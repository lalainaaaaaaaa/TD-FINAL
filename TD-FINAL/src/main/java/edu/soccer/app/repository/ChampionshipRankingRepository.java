package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.ChampionshipRanking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChampionshipRankingRepository {

    private final Connection connection;

    public ChampionshipRankingRepository(Connection connection) {
        this.connection = connection;
    }

    public List<ChampionshipRanking> findAll() throws SQLException {
        List<ChampionshipRanking> rankings = new ArrayList<>();
        String sql = "SELECT teamName, points, wins, draws, losses, goalsFor, goalsAgainst FROM ChampionshipRanking";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ChampionshipRanking ranking = new ChampionshipRanking(
                        rs.getString("teamName"),
                        rs.getInt("points"),
                        rs.getInt("wins"),
                        rs.getInt("draws"),
                        rs.getInt("losses"),
                        rs.getInt("goalsFor"),
                        rs.getInt("goalsAgainst")
                );
                rankings.add(ranking);
            }
        }
        return rankings;
    }

    public void save(ChampionshipRanking ranking) throws SQLException {
        if (ranking.getTeamName() == null || ranking.getTeamName().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty.");
        }
        String sql = "INSERT INTO ChampionshipRanking (teamName, points, wins, draws, losses, goalsFor, goalsAgainst) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, ranking.getTeamName());
            pstmt.setInt(2, ranking.getPoints());
            pstmt.setInt(3, ranking.getWins());
            pstmt.setInt(4, ranking.getDraws());
            pstmt.setInt(5, ranking.getLosses());
            pstmt.setInt(6, ranking.getGoalsFor());
            pstmt.setInt(7, ranking.getGoalsAgainst());
            pstmt.executeUpdate();
        }
    }

    public void update(ChampionshipRanking ranking) throws SQLException {
        String sql = "UPDATE ChampionshipRanking SET points = ?, wins = ?, draws = ?, losses = ?, goalsFor = ?, goalsAgainst = ? WHERE teamName = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, ranking.getPoints());
            pstmt.setInt(2, ranking.getWins());
            pstmt.setInt(3, ranking.getDraws());
            pstmt.setInt(4, ranking.getLosses());
            pstmt.setInt(5, ranking.getGoalsFor());
            pstmt.setInt(6, ranking.getGoalsAgainst());
            pstmt.setString(7, ranking.getTeamName());
            pstmt.executeUpdate();
        }
    }

    public void delete(String teamName) throws SQLException {
        String sql = "DELETE FROM ChampionshipRanking WHERE teamName = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, teamName);
            pstmt.executeUpdate();
        }
    }
}
