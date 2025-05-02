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

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Team homeTeam = findTeamByName(rs.getString("home_team"));
                Team awayTeam = findTeamByName(rs.getString("away_team"));
                Match match = new Match(homeTeam, awayTeam, null); // Remplir les détails nécessaires
                matches.add(match);
            }
        }

        return matches;
    }

    // Ajoutez validation et gestion des erreurs dans d'autres méthodes comme save, update, delete

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

    public void save(Match match) {
        return;
    }
}