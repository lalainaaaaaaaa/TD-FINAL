package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.Player;
import edu.soccer.app.dao.service.BestPlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/players/best")
public class BestPlayerController {

    private final BestPlayerService bestPlayerService;

    public BestPlayerController() {
        this.bestPlayerService = new BestPlayerService();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Player getBestPlayer(@RequestBody List<Player> players) {
        return bestPlayerService.getBestPlayer(players);
    }
}