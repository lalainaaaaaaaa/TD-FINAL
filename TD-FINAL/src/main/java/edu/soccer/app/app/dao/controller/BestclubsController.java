package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.Bestclubs;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/teams/best")
public class BestclubsController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public clubs getBestTeam(@RequestBody List<clubs> teams) {
        return Bestclubs.bestTeam(teams);
    }
}