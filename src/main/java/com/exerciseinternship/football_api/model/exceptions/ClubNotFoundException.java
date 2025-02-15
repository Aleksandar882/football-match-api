package com.exerciseinternship.football_api.model.exceptions;

public class ClubNotFoundException extends RuntimeException{

    public ClubNotFoundException() {
        super("Club doesn't exist!");
    }
}
