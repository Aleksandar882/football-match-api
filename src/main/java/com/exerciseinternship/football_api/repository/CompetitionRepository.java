package com.exerciseinternship.football_api.repository;

import com.exerciseinternship.football_api.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
