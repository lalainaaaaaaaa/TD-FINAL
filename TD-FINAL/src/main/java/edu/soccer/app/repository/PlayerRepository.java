package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    private final Connection connection;

    public PlayerRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Player> findAll() throws SQLException {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM Player";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Player player = new Player(rs.getString("name"), rs.getInt("number"),
                        rs.getString("position"), rs.getString("nationality"),
                        rs.getInt("age"));
                players.add(player);
            }
        }
        return players;
    }

    public void save(Player player) throws SQLException {
        String sql = "INSERT INTO Player (name, number, position, nationality, age) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getNumber());
            pstmt.setString(3, player.getPosition());
            pstmt.setString(4, player.getNationality());
            pstmt.setInt(5, player.getAge());
            pstmt.executeUpdate();
        }
    }

    public void update(Player player) throws SQLException {
        String sql = "UPDATE Player SET position = ?, nationality = ?, age = ? WHERE number = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, player.getPosition());
            pstmt.setString(2, player.getNationality());
            pstmt.setInt(3, player.getAge());
            pstmt.setInt(4, player.getNumber());
            pstmt.executeUpdate();
        }
    }

    public void delete(int number) throws SQLException {
        String sql = "DELETE FROM Player WHERE number = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, number);
            pstmt.executeUpdate();
        }
    }
}