package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.entity.BestTeam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/teams/best")
public class BestTeamController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Team getBestTeam(@RequestBody List<Team> teams) {
        return BestTeam.bestTeam(teams);
    }
}