package com.exerciseinternship.football_api.model.exceptions;

public class CompetitionNotFoundException extends RuntimeException{

    public CompetitionNotFoundException() {
        super("Competition doesn't exist!");
    }
}
