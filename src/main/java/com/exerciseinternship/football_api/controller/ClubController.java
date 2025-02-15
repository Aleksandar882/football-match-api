package com.exerciseinternship.football_api.controller;

import com.exerciseinternship.football_api.model.Club;
import com.exerciseinternship.football_api.model.dto.ClubDTO;
import com.exerciseinternship.football_api.service.ClubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping({"/", "/clubs"})
    public List<Club> getAllClubs(){
        return this.clubService.getAllClubs();
    }

    @PostMapping("/clubs")
    Club addClub(@RequestBody ClubDTO clubDTO){
        return this.clubService.addNewClub(clubDTO);
    }

    @GetMapping("/clubs/{id}")
    Club getClub(@PathVariable Long id){
        return this.clubService.getClubById(id);
    }

    @PutMapping("/clubs/{id}")
    Club updateClub(@PathVariable Long id, @RequestBody ClubDTO clubDTO){
        return this.clubService.updateClub(id, clubDTO);
    }

    @DeleteMapping("/clubs/{id}")
    boolean deleteClub(@PathVariable Long id){
        return this.clubService.delete(id);
    }
}
