package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.championships;
import edu.soccer.app.dao.service.championshipsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/championships")
public class championshipsController {
    private final championshipsService championshipService;

    public championshipsController(championshipsService championshipService) {
        this.championshipService = championshipService;
    }

    @GetMapping
    public List<championships> getAllChampionships() {
        return championshipService.findAll();
    }

    @PostMapping
    public void addChampionship(@RequestBody championships championship) {
        championshipService.save(championship);
    }
}