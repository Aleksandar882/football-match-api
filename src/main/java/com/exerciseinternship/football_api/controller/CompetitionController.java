package com.exerciseinternship.football_api.controller;

import com.exerciseinternship.football_api.model.Competition;
import com.exerciseinternship.football_api.service.CompetitionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompetitionController {

    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("/competitions")
    public Competition getCompetition(@RequestBody Long competitionId) {
        return this.competitionService.getCompetition(competitionId);
    }

    @PostMapping("/competitions")
    public Competition addCompetition(@RequestBody Competition competition) {
        return this.competitionService.addCompetition(competition);
    }

    @PutMapping("/competitions/{id}/winner")
    public Competition setWinner(
            @PathVariable Long id,
            @RequestParam Long winnerId
    ) {
        return this.competitionService.setWinner(id, winnerId);
    }

    @PostMapping("/competitions/{id}/clubs")
    public void addClubsToCompetition(
            @PathVariable Long id,
            @RequestBody List<Long> clubIds
    ) {
        this.competitionService.addClubsToCompetition(id, clubIds);
    }

    @PutMapping("/competitions/{id}/winner/calculate")
    public Competition calculateAndSetWinner(@PathVariable Long id) {
        return this.competitionService.setWinnerAutomatically(id);
    }
}
