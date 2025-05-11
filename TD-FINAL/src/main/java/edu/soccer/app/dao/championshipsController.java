package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class championshipsController {

    private final championships championship;

    // Constructeur simple pour initialiser un championnat avec équipes et saison
    public championshipsController() {
        this.championship = new championships("Ligue 1", "France");

        // Exemple d'initialisation : ajouter des équipes
        clubs club1 = new clubs(1, "Club 1", "C1", 1902, "Stade 1", "Entraîneur 1", "Français");
        clubs club2 = new clubs(2, "Club 2", "C2", 1905, "Stade 2", "Entraîneur 2", "Italien");
        clubs club3 = new clubs(3, "Club 3", "C3", 1910, "Stade 3", "Entraîneur 3", "Allemand");

        championship.addTeam(club1);
        championship.addTeam(club2);
        championship.addTeam(club3);

        // Définir la saison courante
        championship.setCurrentSeason(new season(2024));

        // Exemple : ajouter des joueurs à chaque club (méthode getPlayers() à implémenter dans clubs)
        // club1.addPlayer(...);
        // club2.addPlayer(...);
        // club3.addPlayer(...);
    }

    // POST /api/championships/generateMatches : génère tous les matchs du championnat
    @PostMapping("/championships/generateMatches")
    public List<matches> generateMatches() {
        championship.generateMatches();
        return championship.getMatches();
    }

    // GET /api/championships/statistics : statistiques globales du championnat
    @GetMapping("/championships/statistics")
    public Map<String, Object> getStatistics() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalMatches", championship.getMatches().size());

        Map<String, Integer> pointsByClub = new HashMap<>();
        for (clubs club : championship.getTeams()) {
            int points = club.getStatistics() != null ? club.getStatistics().getPoints() : 0;
            pointsByClub.put(club.getName(), points);
        }
        stats.put("pointsByClub", pointsByClub);

        return stats;
    }

    // GET /api/players?name=&clubName= : liste des joueurs avec filtres optionnels
    @GetMapping("/players")
    public List<players> getPlayers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String clubName) {

        List<players> allPlayers = championship.getTeams().stream()
                .flatMap(club -> club.getPlayers().stream())  // clubs doivent avoir getPlayers()
                .collect(Collectors.toList());

        if (name != null && !name.isEmpty()) {
            allPlayers = allPlayers.stream()
                    .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (clubName != null && !clubName.isEmpty()) {
            allPlayers = allPlayers.stream()
                    .filter(p -> p.getClub().getName().equalsIgnoreCase(clubName))
                    .collect(Collectors.toList());
        }

        return allPlayers;
    }

    // GET /api/players/{id}/statistics/{seasonYear} : statistiques d’un joueur pour une saison donnée
    @GetMapping("/players/{id}/statistics/{seasonYear}")
    public IndividualStatistics getPlayerStatistics(
            @PathVariable String id,
            @PathVariable int seasonYear) {

        Optional<players> playerOpt = championship.getTeams().stream()
                .flatMap(club -> club.getPlayers().stream())
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (playerOpt.isEmpty()) {
            throw new NoSuchElementException("Joueur non trouvé");
        }

        players player = playerOpt.get();

        if (championship.getCurrentSeason() != null && championship.getCurrentSeason().getYear() == seasonYear) {
            return player.getIndividualStatistics();
        } else {
            return new IndividualStatistics(); // ou gérer autrement selon besoin
        }
    }
}
