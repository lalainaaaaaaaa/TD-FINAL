package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.service.seasonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seasons")
public class seasonController {
    private final seasonService seasonService;

    public seasonController(seasonService seasonService) {
        this.seasonService = seasonService;
    }

    @GetMapping
    public List<season> getAllSeasons() {
        return seasonService.findAll();
    }

    @PostMapping
    public void addSeason(@RequestBody season season) {
        seasonService.save(season);
    }

    @PutMapping
    public void updateSeason(@RequestBody season season) {
        seasonService.update(season);
    }

    @DeleteMapping("/{year}")
    public void deleteSeason(@PathVariable int year) {
        seasonService.delete(year);
    }
}