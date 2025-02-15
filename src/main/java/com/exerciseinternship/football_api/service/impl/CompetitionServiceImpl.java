package com.exerciseinternship.football_api.service.impl;

import com.exerciseinternship.football_api.model.Club;
import com.exerciseinternship.football_api.model.Competition;
import com.exerciseinternship.football_api.model.Match;
import com.exerciseinternship.football_api.model.exceptions.ClubNotFoundException;
import com.exerciseinternship.football_api.model.exceptions.CompetitionNotFoundException;
import com.exerciseinternship.football_api.repository.ClubRepository;
import com.exerciseinternship.football_api.repository.CompetitionRepository;
import com.exerciseinternship.football_api.service.CompetitionService;
import com.exerciseinternship.football_api.util.CompetitionStats;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final ClubRepository clubRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository, ClubRepository clubRepository) {
        this.competitionRepository = competitionRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public Competition addCompetition(Competition competition) {
        return this.competitionRepository.save(competition);
    }

    @Override
    public Competition setWinner(Long competitionId, Long winnerId) {
        Competition competition = this.competitionRepository.findById(competitionId).orElseThrow(CompetitionNotFoundException::new);

        Club winner = this.clubRepository.findById(winnerId).orElseThrow(ClubNotFoundException::new);

        competition.setWinner(winner);

        return this.competitionRepository.save(competition);
    }

    @Override
    public void addClubsToCompetition(Long competitionId, List<Long> clubIds) {
        Competition competition = this.competitionRepository.findById(competitionId).orElseThrow(CompetitionNotFoundException::new);

        List<Club> clubs = clubRepository.findAllById(clubIds);
        if (clubs.size() != clubIds.size()) {
            throw new IllegalArgumentException("Some Club IDs are invalid or do not exist.");
        }

        competition.getParticipatingClubs().addAll(clubs);

        this.competitionRepository.save(competition);
    }

    @Override
    public Competition getCompetition(Long competitionId) {
        return this.competitionRepository.findById(competitionId).orElseThrow(CompetitionNotFoundException::new);

    }

    public Club calculateWinner(Long competitionId) {

        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new IllegalArgumentException("Competition not found"));


        Map<Club, CompetitionStats> statsMap = new HashMap<>();
        for (Match match : competition.getMatches()) {
            Club homeTeam = match.getHomeTeam();
            Club awayTeam = match.getAwayTeam();

            statsMap.putIfAbsent(homeTeam, new CompetitionStats());
            statsMap.putIfAbsent(awayTeam, new CompetitionStats());

            CompetitionStats homeStats = statsMap.get(homeTeam);
            CompetitionStats awayStats = statsMap.get(awayTeam);

            if (match.getHomeTeamScore() > match.getAwayTeamScore()) {
                homeStats.addWin(match.getHomeTeamScore(), match.getAwayTeamScore());
                awayStats.addLoss(match.getAwayTeamScore(), match.getHomeTeamScore());
            } else if (match.getHomeTeamScore() < match.getAwayTeamScore()) {
                awayStats.addWin(match.getAwayTeamScore(), match.getHomeTeamScore());
                homeStats.addLoss(match.getHomeTeamScore(), match.getAwayTeamScore());
            } else {
                homeStats.addDraw(match.getHomeTeamScore(), match.getAwayTeamScore());
                awayStats.addDraw(match.getAwayTeamScore(), match.getHomeTeamScore());
            }
        }

        return statsMap.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalStateException("No clubs found in competition"));
    }

    public Competition setWinnerAutomatically(Long competitionId) {
        Club winner = calculateWinner(competitionId);
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new IllegalArgumentException("Competition not found"));

        competition.setWinner(winner);
        return competitionRepository.save(competition);
    }
}
