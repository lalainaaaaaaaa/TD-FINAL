package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.matches;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class matchesService {

    public List<matches> findAll() {
        return List.of();
    }

    public void save(matches match) {

    }
}
