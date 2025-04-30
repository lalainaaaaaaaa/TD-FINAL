package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.BestMatch;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches/best")
public class BestMatchController {


    @PostMapping
    public Match getBestMatch(@RequestBody List<Match> matches) {
        return BestMatch.bestMatch(matches);
    }
}
