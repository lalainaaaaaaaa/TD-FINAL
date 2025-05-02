package edu.soccer.app.repository;

import edu.soccer.app.dao.entity.Bestplayers;
import edu.soccer.app.dao.entity.IndividualStatistics;
import edu.soccer.app.dao.entity.players;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BestplayersRepository {

    private final DataSource dataSource;

    public BestplayersRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<players> findAll() throws SQLException {
        List<players> players = new ArrayList<>();
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

                edu.soccer.app.dao.entity.players player = new players(name, position, nationality);
                players.add(player);
            }
        }

        return players;
    }

    public players getBestPlayer() throws SQLException {
        List<players> players = findAll();
        return Bestplayers.bestPlayer(players);
    }
}