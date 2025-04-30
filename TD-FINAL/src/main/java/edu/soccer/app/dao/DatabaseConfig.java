package edu.soccer.app.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");

        String dbUrl = System.getenv("DB_URL");
        String dbUsername = System.getenv("DB_USERNAME");
        String dbPassword = System.getenv("DB_PASSWORD");

        if (dbUrl == null || dbUsername == null || dbPassword == null) {
            dbUrl = "jdbc:postgresql://localhost:5432/soccer";
            dbUsername = "postgres";
            dbPassword = "azerty";
        }

        if (dbUrl == null || dbUsername == null || dbPassword == null) {
            throw new RuntimeException("Database configuration is not properly defined.");
        }

        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);

        return dataSource;
    }
}
