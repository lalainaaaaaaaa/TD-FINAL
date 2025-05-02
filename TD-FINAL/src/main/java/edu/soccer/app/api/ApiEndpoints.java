package edu.soccer.app.api;

import edu.soccer.app.dao.entity.CollectiveStatistics;
import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.IndividualStatistics;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiEndpoints {

    private List<players> playersList = new ArrayList<>(); // Simule une base de données temporaire
    private List<matches> matchesList = new ArrayList<>();   // Simule une base de données pour les matches
    private List<season> seasonsList = new ArrayList<>();   // Simule une base de données pour les saisons
    private List<clubs> clubsList = new ArrayList<>();       // Simule une base de données pour les clubs

    // Récupérer tous les joueurs avec filtrage
    @GetMapping("/players")
    public List<players> getAllPlayers(@RequestParam(required = false) String club,
                                       @RequestParam(required = false) String name,
                                       @RequestParam(required = false) Integer ageMin,
                                       @RequestParam(required = false) Integer ageMax) {
        return playersList.stream()
                .filter(player -> (club == null || player.getClub().equals(club)) &&
                        (name == null || player.getName().contains(name)) &&
                        (ageMin == null || player.getAge() >= ageMin) &&
                        (ageMax == null || player.getAge() <= ageMax))
                .collect(Collectors.toList());
    }

    // Ajouter un nouveau joueur
    @PostMapping("/players")
    public players addPlayer(@RequestBody players player) {
        playersList.add(player); // Ajoute un joueur à la liste
        return player; // Retourne le joueur ajouté
    }

    // Mettre à jour un joueur
    @PutMapping("/players/{id}")
    public players updatePlayer(@PathVariable String id, @RequestBody players updatedPlayer) {
        playersList.removeIf(p -> p.getId().equals(id));
        playersList.add(updatedPlayer); // Ajoute le joueur mis à jour
        return updatedPlayer; // Retourne le joueur mis à jour
    }

    // Récupérer toutes les saisons
    @GetMapping("/seasons")
    public List<season> getAllSeasons() {
        return seasonsList; // Retourne toutes les saisons
    }

    // Ajouter une nouvelle saison
    @PostMapping("/seasons")
    public season addSeason(@RequestBody season season) {
        seasonsList.add(season); // Ajoute une saison à la liste
        return season; // Retourne la saison ajoutée
    }

    // Mettre à jour le statut d'une saison
    @PutMapping("/seasons/{seasonYear}/status")
    public String updateSeasonStatus(@PathVariable int seasonYear, @RequestBody String status) {
        // Implémentez la logique pour mettre à jour le statut d'une saison
        return "Season " + seasonYear + " status updated to " + status;
    }

    // Récupérer les statistiques d'un joueur pour une saison donnée
    @GetMapping("/players/{id}/statistics/{seasonYear}")
    public IndividualStatistics getPlayerStatistics(@PathVariable String id, @PathVariable int seasonYear) {
        // Implémentez la logique pour récupérer les statistiques d'un joueur
        return new IndividualStatistics(); // Retourne des statistiques par défaut pour l'instant
    }

    // Récupérer tous les clubs
    @GetMapping("/clubs")
    public List<clubs> getAllClubs() {
        return clubsList; // Retourne tous les clubs
    }

    // Mettre à jour un club
    @PutMapping("/clubs")
    public clubs updateClub(@RequestBody clubs club) {
        // Implémentez la logique pour mettre à jour un club
        return club; // Retourne le club mis à jour
    }

    // Récupérer tous les joueurs d'un club
    @GetMapping("/clubs/{id}/players")
    public List<players> getPlayersByClub(@PathVariable String id) {
        // Implémentez la logique pour récupérer les joueurs d'un club
        return new ArrayList<>(); // Retourne une liste vide pour l'instant
    }

    // Mettre à jour les joueurs d'un club
    @PutMapping("/clubs/{id}/players")
    public String updateClubPlayers(@PathVariable String id, @RequestBody List<String> playerIds) {
        // Implémentez la logique pour mettre à jour les joueurs d'un club
        return "Club " + id + " players updated.";
    }

    // Ajouter un joueur à un club
    @PostMapping("/clubs/{id}/players")
    public String addPlayerToClub(@PathVariable String id, @RequestBody String playerId) {
        // Implémentez la logique pour ajouter un joueur à un club
        return "Player " + playerId + " added to club " + id;
    }

    // Générer des matches pour une saison donnée
    @PostMapping("/matchMaker/{seasonYear}")
    public String generateMatches(@PathVariable int seasonYear) {
        // Implémentez la logique pour générer des matches pour une saison
        return "Matches generated for season " + seasonYear;
    }

    // Récupérer tous les matches d'une saison
    @GetMapping("/matches/{seasonYear}")
    public List<matches> getMatchesBySeason(@PathVariable int seasonYear) {
        // Implémentez la logique pour récupérer les matches d'une saison
        return new ArrayList<>(); // Retourne une liste vide pour l'instant
    }

    // Mettre à jour le statut d'un match
    @PutMapping("/matches/{id}/status")
    public String updateMatchStatus(@PathVariable String id, @RequestBody String status) {
        // Implémentez la logique pour mettre à jour le statut d'un match
        return "Match " + id + " status updated to " + status;
    }

    // Mettre à jour les buts d'un match
    @PostMapping("/matches/{id}/goals")
    public String updateMatchGoals(@PathVariable String id, @RequestBody String goals) {
        // Implémentez la logique pour mettre à jour les buts d'un match
        return "Goals for match " + id + " updated to " + goals;
    }

    // Récupérer les statistiques d'un club pour une saison donnée
    @GetMapping("/clubs/statistics/{seasonYear}")
    public CollectiveStatistics getClubStatistics(@PathVariable int seasonYear) {
        // Implémentez la logique pour récupérer les statistiques d'un club
        return new CollectiveStatistics(); // Retourne des statistiques par défaut pour l'instant
    }
}