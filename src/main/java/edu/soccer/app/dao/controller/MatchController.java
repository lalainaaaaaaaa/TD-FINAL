package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.findAll();
    }

    @PostMapping
    public void addMatch(@RequestBody Match match) {
        matchService.save(match);
    }
}