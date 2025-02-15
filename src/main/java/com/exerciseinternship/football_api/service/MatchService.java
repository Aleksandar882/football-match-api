package com.exerciseinternship.football_api.service;

import com.exerciseinternship.football_api.model.Club;
import com.exerciseinternship.football_api.model.Match;
import com.exerciseinternship.football_api.model.dto.MatchDTO;

import java.time.LocalDate;
import java.util.List;

public interface MatchService {

    Match addNewMatch(MatchDTO matchDTO);

    List<Match> getAllMatches();

    Match getMatchById(Long id);

    Match updateMatch(Long id, MatchDTO matchDTO);

    boolean delete(Long id);

}
