package com.exerciseinternship.football_api.service;

import com.exerciseinternship.football_api.model.Club;
import com.exerciseinternship.football_api.model.dto.ClubDTO;

import java.util.List;

public interface ClubService {

    Club addNewClub(ClubDTO clubDTO);

    List<Club> getAllClubs();

    Club getClubById(Long id);

    Club updateClub(Long id, ClubDTO clubDTO );

    boolean delete(Long id);

}
