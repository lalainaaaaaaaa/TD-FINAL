package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.service.clubsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class clubsController {
    private final clubsService teamService;

    public clubsController(clubsService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<clubs> getAllTeams() {
        return teamService.findAll();
    }

    @PostMapping
    public void addTeam(@RequestBody clubs team) {
        teamService.save(team);
    }
}