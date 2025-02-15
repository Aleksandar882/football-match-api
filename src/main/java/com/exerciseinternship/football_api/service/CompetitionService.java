package com.exerciseinternship.football_api.service;

import com.exerciseinternship.football_api.model.Club;
import com.exerciseinternship.football_api.model.Competition;

import java.util.List;

public interface CompetitionService {

    Competition addCompetition(Competition competition);

    Competition setWinner(Long competitionId, Long winnerId);

    void addClubsToCompetition(Long competitionId, List<Long> clubIds);

    Competition getCompetition(Long competitionId);

    Club calculateWinner(Long competitionId);

    Competition setWinnerAutomatically(Long competitionId);

}
