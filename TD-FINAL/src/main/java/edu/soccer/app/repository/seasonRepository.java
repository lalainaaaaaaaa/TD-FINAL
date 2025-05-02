package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.season;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class seasonRepository {
    private final Connection connection;

    public seasonRepository(Connection connection) {
        this.connection = connection;
    }

    public List<season> findAll() throws SQLException {
        List<season> seasons = new ArrayList<>();
        String sql = "SELECT * FROM Season";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int year = rs.getInt("year");
                season season = new season(year);
                seasons.add(season);
            }
        }
        return seasons;
    }

    public void save(season season) throws SQLException {
        if (season.getYear() <= 0) {
            throw new IllegalArgumentException("Season year must be greater than zero.");
        }
        String sql = "INSERT INTO Season (year) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, season.getYear());
            pstmt.executeUpdate();
        }
    }

    public void update(season season) throws SQLException {
        String sql = "UPDATE Season SET year = ? WHERE year = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, season.getYear());
            pstmt.setInt(2, season.getYear());
            pstmt.executeUpdate();
        }
    }

    public void delete(int year) throws SQLException {
        String sql = "DELETE FROM Season WHERE year = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, year);
            pstmt.executeUpdate();
        }
    }
}