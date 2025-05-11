package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class matchMakerRepository {

    private final Connection connection;

    public matchMakerRepository(Connection connection) {
        this.connection = connection;
    }

    public List<matches> findAll() throws SQLException {
        List<matches> matchesList = new ArrayList<>();
        String sql = "SELECT m.id, m.home_team_id, m.away_team_id, m.season_year, m.status, m.home_score, m.away_score, " +
                "ht.name as home_team_name, ht.stadium as home_team_stadium, " +
                "at.name as away_team_name, at.stadium as away_team_stadium " +
                "FROM matches m " +
                "JOIN clubs ht ON m.home_team_id = ht.id " +
                "JOIN clubs at ON m.away_team_id = at.id";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Construire les objets clubs pour homeTeam et awayTeam
                clubs homeTeam = new clubs(
                        rs.getInt("home_team_id"),
                        rs.getString("home_team_name"),
                        null, 0, // acronym, yearOfCreation à adapter
                        rs.getString("home_team_stadium"),
                        null, null);

                clubs awayTeam = new clubs(
                        rs.getInt("away_team_id"),
                        rs.getString("away_team_name"),
                        null, 0,
                        rs.getString("away_team_stadium"),
                        null, null);

                // Construire l'objet season
                season season = new season(rs.getInt("season_year"));

                // Construire l'objet matches
                matches match = new matches(homeTeam, awayTeam, season);
                match.setStatus(rs.getString("status"));
                match.setHomeScore(rs.getInt("home_score"));
                match.setAwayScore(rs.getInt("away_score"));

                matchesList.add(match);
            }
        }
        return matchesList;
    }

    public matches getBestMatch() throws SQLException {
        // Exemple simple : match avec la plus grande différence de score
        List<matches> allMatches = findAll();
        if (allMatches.isEmpty()) return null;

        matches bestMatch = allMatches.get(0);
        int maxDiff = Math.abs(bestMatch.getHomeScore() - bestMatch.getAwayScore());

        for (matches m : allMatches) {
            int diff = Math.abs(m.getHomeScore() - m.getAwayScore());
            if (diff > maxDiff) {
                maxDiff = diff;
                bestMatch = m;
            }
        }
        return bestMatch;
    }
}
