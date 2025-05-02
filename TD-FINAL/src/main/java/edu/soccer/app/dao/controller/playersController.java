package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.service.BestplayersService;
import edu.soccer.app.dao.service.playersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class playersController {
    private final playersService playerService;

    public playersController(playersService playerService) {
        this.playerService = playerService;
    }


    @GetMapping
    public List<players> getAllPlayers() {
        return playerService.findAll();
    }

    @PostMapping
    public void addPlayer(@RequestBody players player) {
        playerService.save(player);
    }
}