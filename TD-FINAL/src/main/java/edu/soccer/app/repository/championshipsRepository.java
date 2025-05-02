package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.championships;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class championshipsRepository {
    private final Connection connection;

    public championshipsRepository(Connection connection) {
        this.connection = connection;
    }

    public List<championships> findAll() throws SQLException {
        List<championships> championships = new ArrayList<>();
        String sql = "SELECT * FROM Championship";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                edu.soccer.app.dao.entity.championships championship = new championships(rs.getString("name"), rs.getString("country"));
                championships.add(championship);
            }
        }
        return championships;
    }

    public void save(championships championship) throws SQLException {
        if (championship.getName() == null || championship.getName().isEmpty()) {
            throw new IllegalArgumentException("Championship name cannot be null or empty.");
        }
        String sql = "INSERT INTO Championship (name, country) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, championship.getName());
            pstmt.setString(2, championship.getCountry());
            pstmt.executeUpdate();
        }
    }

    public void update(championships championship) throws SQLException {
        String sql = "UPDATE Championship SET country = ? WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, championship.getCountry());
            pstmt.setString(2, championship.getName());
            pstmt.executeUpdate();
        }
    }

    public void delete(String name) throws SQLException {
        String sql = "DELETE FROM Championship WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
}