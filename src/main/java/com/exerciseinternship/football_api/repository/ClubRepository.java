package com.exerciseinternship.football_api.repository;

import com.exerciseinternship.football_api.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
