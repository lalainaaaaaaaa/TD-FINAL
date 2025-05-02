package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.Player;
import edu.soccer.app.dao.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.findAll();
    }

    @PostMapping
    public void addPlayer(@RequestBody Player player) {
        playerService.save(player);
    }
}