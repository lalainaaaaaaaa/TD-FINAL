package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.Season;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeasonRepository {
    private final Connection connection;

    public SeasonRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Season> findAll() throws SQLException {
        List<Season> seasons = new ArrayList<>();
        String sql = "SELECT * FROM Season";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Season season = new Season(rs.getInt("year"));
                seasons.add(season);
            }
        }
        return seasons;
    }

    public void save(Season season) throws SQLException {
        String sql = "INSERT INTO Season (year) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(season.getYear()));
            pstmt.executeUpdate();
        }
    }

    public void update(Season season) throws SQLException {
        String sql = "UPDATE Season SET year = ? WHERE year = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(season.getYear()));
            pstmt.setInt(2, Integer.parseInt(season.getYear()));
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