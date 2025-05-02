package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.Season;
import edu.soccer.app.dao.service.SeasonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seasons")
public class SeasonController {
    private final SeasonService seasonService;

    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @GetMapping
    public List<Season> getAllSeasons() {
        return seasonService.findAll();
    }

    @PostMapping
    public void addSeason(@RequestBody Season season) {
        seasonService.save(season);
    }

    @PutMapping
    public void updateSeason(@RequestBody Season season) {
        seasonService.update(season);
    }

    @DeleteMapping("/{year}")
    public void deleteSeason(@PathVariable int year) {
        seasonService.delete(year);
    }
}