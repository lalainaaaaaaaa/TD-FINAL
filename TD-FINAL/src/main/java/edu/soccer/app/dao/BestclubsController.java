package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.Bestclubs;
import edu.soccer.app.dao.entity.players;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/teams/best")
public class BestclubsController {

    public static List<players> getBestplayers(String top, String playingTimeUnit) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public clubs getBestTeam(@RequestBody List<clubs> teams) {
        return Bestclubs.bestTeam(teams);
    }
}