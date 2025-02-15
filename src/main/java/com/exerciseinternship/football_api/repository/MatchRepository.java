package com.exerciseinternship.football_api.repository;

import com.exerciseinternship.football_api.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,Long> {
}
