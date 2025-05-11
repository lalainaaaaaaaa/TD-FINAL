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
        String sql = "SELECT id, name, stadium, acronym, yearOfCreation, coach, nationality FROM Clubs";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clubs club = new clubs(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("acronym"),
                        rs.getInt("yearOfCreation"),
                        rs.getString("stadium"),
                        rs.getString("coach"),
                        rs.getString("nationality")
                );
                clubsList.add(club);
            }
        }
        return clubsList;
    }

    public void save(clubs club) throws SQLException {
        if (club.getName() == null || club.getName().isEmpty()) {
            throw new IllegalArgumentException("Club name cannot be null or empty.");
        }
        String sql = "INSERT INTO Clubs (id, name, stadium, acronym, yearOfCreation, coach, nationality) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, club.getId());
            pstmt.setString(2, club.getName());
            pstmt.setString(3, club.getStadium());
            pstmt.setString(4, club.getAcronym());
            pstmt.setInt(5, club.getYearOfCreation());
            pstmt.setString(6, club.getCoach());
            pstmt.setString(7, club.getNationality());
            pstmt.executeUpdate();
        }
    }

    public void update(clubs club) throws SQLException {
        String sql = "UPDATE Clubs SET name = ?, stadium = ?, acronym = ?, yearOfCreation = ?, coach = ?, nationality = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, club.getName());
            pstmt.setString(2, club.getStadium());
            pstmt.setString(3, club.getAcronym());
            pstmt.setInt(4, club.getYearOfCreation());
            pstmt.setString(5, club.getCoach());
            pstmt.setString(6, club.getNationality());
            pstmt.setInt(7, club.getId());
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
        String sql = "SELECT id, name, stadium, acronym, yearOfCreation, coach, nationality FROM Clubs WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new clubs(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("acronym"),
                            rs.getInt("yearOfCreation"),
                            rs.getString("stadium"),
                            rs.getString("coach"),
                            rs.getString("nationality")
                    );
                }
            }
        }
        return null;
    }
}
