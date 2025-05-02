package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.service.BestplayersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/players/best")
public class BestplayersController {

    private final BestplayersService bestPlayerService;

    public BestplayersController() {
        this.bestPlayerService = new BestplayersService();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public players getBestPlayer(@RequestBody List<players> players) {
        return bestPlayerService.getBestPlayer(players);
    }
}