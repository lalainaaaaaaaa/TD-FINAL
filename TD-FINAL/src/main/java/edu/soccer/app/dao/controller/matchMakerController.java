package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.matchMaker;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/matches/best")
public class matchMakerController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public matches getBestMatch(@RequestBody List<matches> matches) {
        return matchMaker.bestMatch(matches);
    }
}