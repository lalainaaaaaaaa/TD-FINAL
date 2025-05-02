package edu.soccer.app.dao.management;

import edu.soccer.app.dao.entity.matches;
import java.util.List;

public class FIFAManagement {
    private final APIManagement apiManagement;

    public FIFAManagement(APIManagement apiManagement) {
        this.apiManagement = apiManagement;
    }

    public String collectData() {
        StringBuilder result = new StringBuilder("Collecting data from championships... ");
        List<matches> allMatches = apiManagement.retrieveMatchStatistics();
        if (allMatches != null && !allMatches.isEmpty()) {
            for (matches match : allMatches) {
                result.append("Match: ").append(match.getHomeTeam().getName())
                        .append(" vs ").append(match.getAwayTeam().getName()).append(". ");
            }
        } else {
            result.append("No match data available. ");
        }
        return result.toString();
    }

    public String analyzeStatistics() {
        StringBuilder result = new StringBuilder("Analyzing statistics... ");
        List<matches> allMatches = apiManagement.retrieveMatchStatistics();
        if (allMatches != null && !allMatches.isEmpty()) {
            matches bestMatch = null;
            int maxScoreDifference = 0;

            for (matches match : allMatches) {
                int scoreDifference = Math.abs(match.getHomeScore() - match.getAwayScore());
                if (scoreDifference > maxScoreDifference) {
                    maxScoreDifference = scoreDifference;
                    bestMatch = match;
                }
            }

            if (bestMatch != null) {
                result.append("Match with highest score difference: ")
                        .append(bestMatch.getHomeTeam().getName()).append(" vs ")
                        .append(bestMatch.getAwayTeam().getName())
                        .append(" (").append(bestMatch.getHomeScore()).append("-")
                        .append(bestMatch.getAwayScore()).append("). ");
            } else {
                result.append("No match found to analyze. ");
            }
        } else {
            result.append("No match data available for analysis. ");
        }
        return result.toString();
    }
}