package com.exerciseinternship.football_api.service.impl;

import com.exerciseinternship.football_api.model.Club;
import com.exerciseinternship.football_api.model.Competition;
import com.exerciseinternship.football_api.model.Match;
import com.exerciseinternship.football_api.model.dto.MatchDTO;
import com.exerciseinternship.football_api.model.exceptions.ClubNotFoundException;
import com.exerciseinternship.football_api.model.exceptions.CompetitionNotFoundException;
import com.exerciseinternship.football_api.model.exceptions.MatchNotFoundException;
import com.exerciseinternship.football_api.repository.ClubRepository;
import com.exerciseinternship.football_api.repository.CompetitionRepository;
import com.exerciseinternship.football_api.repository.MatchRepository;
import com.exerciseinternship.football_api.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    private final ClubRepository clubRepository;

    private final CompetitionRepository competitionRepository;

    public MatchServiceImpl(MatchRepository matchRepository, ClubRepository clubRepository, CompetitionRepository competitionRepository) {
        this.matchRepository = matchRepository;
        this.clubRepository = clubRepository;
        this.competitionRepository = competitionRepository;
    }

    @Override
    public Match addNewMatch(MatchDTO matchDTO) {
        Club homeTeam = this.clubRepository.findById(matchDTO.getHomeTeamId()).orElseThrow(ClubNotFoundException::new);
        Club awayTeam = this.clubRepository.findById(matchDTO.getAwayTeamId()).orElseThrow(ClubNotFoundException::new);
        Competition competition = this.competitionRepository.findById(matchDTO.getCompetitionId()).orElseThrow(CompetitionNotFoundException::new);

        Match match = new Match();
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setMatchDate(matchDTO.getMatchDate());
        match.setHomeTeamScore(matchDTO.getHomeTeamScore());
        match.setAwayTeamScore(matchDTO.getAwayTeamScore());
        match.setCompetition(competition);
        return this.matchRepository.save(match);
    }

    @Override
    public List<Match> getAllMatches() {
        return this.matchRepository.findAll();
    }

    @Override
    public Match getMatchById(Long id) {
        return this.matchRepository.findById(id).orElseThrow(MatchNotFoundException::new);
    }

    @Override
    public Match updateMatch(Long id, MatchDTO matchDTO) {
        Club homeTeam = this.clubRepository.findById(matchDTO.getHomeTeamId()).orElseThrow(ClubNotFoundException::new);
        Club awayTeam = this.clubRepository.findById(matchDTO.getAwayTeamId()).orElseThrow(ClubNotFoundException::new);

        Match match = this.matchRepository.findById(id).orElseThrow(MatchNotFoundException::new);
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setMatchDate(matchDTO.getMatchDate());
        match.setHomeTeamScore(matchDTO.getHomeTeamScore());
        match.setAwayTeamScore(matchDTO.getAwayTeamScore());
        return this.matchRepository.save(match);
    }

    @Override
    public boolean delete(Long id) {
        this.matchRepository.deleteById(id);
        return this.matchRepository.findById(id).isEmpty();
    }
}
