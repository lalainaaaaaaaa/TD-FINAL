package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.clubs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class clubsRepository {

    private final Connection connection;

    public clubsRepository(Connection connection) {
        this.connection = connection;
    }


    public List<clubs> findAll() throws SQLException {
        List<clubs> clubsList = new ArrayList<>();
        String sql = "SELECT id, name, stadium, acronym, yearFounded, points FROM Clubs";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clubs club = new clubs(rs.getString("name"));
                club.setStadium(rs.getString("stadium"));
                club.setAcronym(rs.getString("acronym"));
                club.setYearFounded(rs.getInt("yearFounded"));
                club.setPoints(rs.getInt("points"));

                clubsList.add(club);
            }
        }
        return clubsList;
    }

    // Ajouter un club
    public void save(clubs club) throws SQLException {
        if (club.getName() == null || club.getName().isEmpty()) {
            throw new IllegalArgumentException("Club name cannot be null or empty.");
        }
        String sql = "INSERT INTO Clubs (id, name, stadium, acronym, yearFounded, points) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, club.getId());
            pstmt.setString(2, club.getName());
            pstmt.setString(3, club.getStadium());
            pstmt.setString(4, club.getAcronym());
            pstmt.setInt(5, club.getYearFounded());
            pstmt.setInt(6, club.getPoints());
            pstmt.executeUpdate();
        }
    }


    public void update(clubs club) throws SQLException {
        String sql = "UPDATE Clubs SET name = ?, stadium = ?, acronym = ?, yearFounded = ?, points = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, club.getName());
            pstmt.setString(2, club.getStadium());
            pstmt.setString(3, club.getAcronym());
            pstmt.setInt(4, club.getYearFounded());
            pstmt.setInt(5, club.getPoints());
            pstmt.setInt(6, club.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteByName(String name) throws SQLException {
        String sql = "DELETE FROM Clubs WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }


    public clubs findByName(String name) throws SQLException {
        String sql = "SELECT id, name, stadium, acronym, yearFounded, points FROM Clubs WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    clubs club = new clubs(rs.getString("name"));
                    club.setStadium(rs.getString("stadium"));
                    club.setAcronym(rs.getString("acronym"));
                    club.setYearFounded(rs.getInt("yearFounded"));
                    club.setPoints(rs.getInt("points"));
                    return club;
                }
            }
        }
        return null;
    }
}
