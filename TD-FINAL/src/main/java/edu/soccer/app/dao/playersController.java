package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.service.playersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class playersController {

    private final playersService playersService;

    public playersController(playersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping("/api/players")
    public List<players> getPlayers(
            @RequestParam(required = false) String club,
            @RequestParam(required = false) String name) {

        // Récupération de tous les joueurs
        List<players> allPlayers = playersService.findAll();

        // Filtrage local selon les paramètres
        return allPlayers.stream()
                .filter(player -> {
                    if (club == null || club.isEmpty()) return true;
                    if (player.getClub() == null) return false;
                    return player.getClub().getName().equalsIgnoreCase(club);
                })
                .filter(player -> {
                    if (name == null || name.isEmpty()) return true;
                    return player.getName() != null && player.getName().toLowerCase().contains(name.toLowerCase());
                })
                .collect(Collectors.toList());
    }
}
