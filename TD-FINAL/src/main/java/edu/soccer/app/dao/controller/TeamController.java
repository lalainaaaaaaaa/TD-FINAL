package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }

    @PostMapping
    public void addTeam(@RequestBody Team team) {
        teamService.save(team);
    }
}