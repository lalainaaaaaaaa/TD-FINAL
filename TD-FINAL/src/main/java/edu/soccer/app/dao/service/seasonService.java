package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.season;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class seasonService {

    public List<season> findAll() {
        return List.of();
    }

    public void save(season s) {

    }

    public void update(season s) {

    }

    public void delete(int year) {

    }

    public season findByYear(int year) {

        return null;
    }
}
