package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.service.matchesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class matchesController {
    private final matchesService matchService;

    public matchesController(matchesService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<matches> getAllMatches() {
        return matchService.findAll();
    }

    @PostMapping
    public void addMatch(@RequestBody matches match) {
        matchService.save(match);
    }
}