package com.exerciseinternship.football_api.model.exceptions;

public class MatchNotFoundException extends RuntimeException{

    public MatchNotFoundException() {
        super("Match doesn't exist!");
    }
}

