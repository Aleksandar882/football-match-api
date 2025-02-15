package com.exerciseinternship.football_api.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int yearFounded;

    @ManyToMany(mappedBy = "participatingClubs")
    private List<Competition> competitions = new ArrayList<>();

    public Club(String name, int yearFounded) {
        this.name = name;
        this.yearFounded = yearFounded;
    }

    public Club() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }
}
