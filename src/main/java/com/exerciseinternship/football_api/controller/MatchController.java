package com.exerciseinternship.football_api.controller;

import com.exerciseinternship.football_api.model.Club;
import com.exerciseinternship.football_api.model.Match;
import com.exerciseinternship.football_api.model.dto.MatchDTO;
import com.exerciseinternship.football_api.service.ClubService;
import com.exerciseinternship.football_api.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/matches")
    public List<Match> getAllMatches(){
        return this.matchService.getAllMatches();
    }

    @PostMapping("/matches")
    Match addMatch(@RequestBody MatchDTO matchDTO){
        return this.matchService.addNewMatch(matchDTO);
    }

    @GetMapping("/matches/{id}")
    Match getMatch(@PathVariable Long id){
        return this.matchService.getMatchById(id);
    }

    @PutMapping("/matches/{id}")
    Match updateMatch(@PathVariable Long id, @RequestBody MatchDTO matchDTO){
        return this.matchService.updateMatch(id, matchDTO);
    }

    @DeleteMapping("/matches/{id}")
    boolean deleteMatch(@PathVariable Long id){
        return this.matchService.delete(id);
    }
}
