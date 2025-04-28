package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.Championship;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChampionshipRepository {
    private final Connection connection;

    public ChampionshipRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Championship> findAll() throws SQLException {
        List<Championship> championships = new ArrayList<>();
        String sql = "SELECT * FROM championships";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Championship championship = new Championship(rs.getString("name"), rs.getString("country"));
                championships.add(championship);
            }
        }
        return championships;
    }

    public void save(Championship championship) throws SQLException {
        String sql = "INSERT INTO championships (name, country) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, championship.getName());
            pstmt.setString(2, championship.getCountry());
            pstmt.executeUpdate();
        }
    }

    public void update(Championship championship) throws SQLException {
        String sql = "UPDATE championships SET country = ? WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, championship.getCountry());
            pstmt.setString(2, championship.getName());
            pstmt.executeUpdate();
        }
    }

    public void delete(String name) throws SQLException {
        String sql = "DELETE FROM championships WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
}