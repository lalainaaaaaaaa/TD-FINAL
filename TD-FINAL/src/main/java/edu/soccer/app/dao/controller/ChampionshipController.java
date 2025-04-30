package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.Championship;
import edu.soccer.app.dao.service.ChampionshipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/championships")
public class ChampionshipController {
    private final ChampionshipService championshipService;

    public ChampionshipController(ChampionshipService championshipService) {
        this.championshipService = championshipService;
    }

    @GetMapping
    public List<Championship> getAllChampionships() {
        return championshipService.findAll();
    }

    @PostMapping
    public void addChampionship(@RequestBody Championship championship) {
        championshipService.save(championship);
    }
}