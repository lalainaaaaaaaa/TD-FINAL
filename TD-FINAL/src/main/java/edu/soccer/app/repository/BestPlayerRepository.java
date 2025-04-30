package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.BestPlayer;
import edu.soccer.app.dao.entity.IndividualStatistics;
import edu.soccer.app.dao.entity.Player;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BestPlayerRepository {

    private final DataSource dataSource;

    public BestPlayerRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Player> findAll() throws SQLException {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM Player";

        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String name = rs.getString("name");
                int number = rs.getInt("number");
                String position = rs.getString("position");
                String nationality = rs.getString("nationality");
                int age = rs.getInt("age");
                int goalsScored = rs.getInt("goals");
                int playingTime = rs.getInt("playing_time");

                IndividualStatistics stats = new IndividualStatistics();
                stats.updateGoals(goalsScored);
                stats.updatePlayingTime(playingTime);

                Player player = new Player(name, position, nationality);
                players.add(player);
            }
        }

        return players;
    }

    public Player getBestPlayer() throws SQLException {
        List<Player> players = findAll();
        return BestPlayer.bestPlayer(players);
    }
}