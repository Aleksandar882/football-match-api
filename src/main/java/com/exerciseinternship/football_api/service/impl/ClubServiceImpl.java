package com.exerciseinternship.football_api.service.impl;

import com.exerciseinternship.football_api.model.Club;
import com.exerciseinternship.football_api.model.dto.ClubDTO;
import com.exerciseinternship.football_api.model.exceptions.ClubNotFoundException;
import com.exerciseinternship.football_api.repository.ClubRepository;
import com.exerciseinternship.football_api.service.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Club addNewClub(ClubDTO clubDTO) {
        Club club = new Club();
        club.setName(clubDTO.getName());
        club.setYearFounded(clubDTO.getYearFounded());
        return this.clubRepository.save(club);
    }

    @Override
    public List<Club> getAllClubs() {
        return this.clubRepository.findAll();
    }

    @Override
    public Club getClubById(Long id) {
        return this.clubRepository.findById(id).orElseThrow(ClubNotFoundException::new);
    }

    @Override
    public Club updateClub(Long id, ClubDTO clubDTO ) {
        Club club = this.clubRepository.findById(id).orElseThrow(ClubNotFoundException::new);
        club.setName(clubDTO.getName());
        club.setYearFounded(clubDTO.getYearFounded());
        return this.clubRepository.save(club);
    }

    @Override
    public boolean delete(Long id) {
        this.clubRepository.deleteById(id);
        return this.clubRepository.findById(id).isEmpty();
    }
}
