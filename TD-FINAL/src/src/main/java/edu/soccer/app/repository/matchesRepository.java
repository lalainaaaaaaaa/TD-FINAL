package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.clubs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class matchesRepository {
    private final Connection connection;

    public matchesRepository(Connection connection) {
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
                edu.soccer.app.dao.entity.matches match = new matches(homeTeam, awayTeam, null); // Remplir les détails nécessaires
                matches.add(match);
            }
        }

        return matches;
    }

    // Ajoutez validation et gestion des erreurs dans d'autres méthodes comme save, update, delete

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

    public void save(matches match) {
        return;
    }
}