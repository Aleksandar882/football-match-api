package com.exerciseinternship.football_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Club getWinner() {
        return winner;
    }

    public void setWinner(Club winner) {
        this.winner = winner;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public List<Club> getParticipatingClubs() {
        return participatingClubs;
    }

    public void setParticipatingClubs(List<Club> participatingClubs) {
        this.participatingClubs = participatingClubs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Competition() {
    }

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Club winner;

    @JsonIgnore
    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
    private List<Match> matches = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "club_competition",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    private List<Club> participatingClubs = new ArrayList<>();
}