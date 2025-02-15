package com.exerciseinternship.football_api.util;

public class CompetitionStats implements Comparable<CompetitionStats> {
    private int points;
    private int goalsScored;
    private int goalsConceded;

    public void addWin(int scored, int conceded) {
        this.points += 3;
        this.goalsScored += scored;
        this.goalsConceded += conceded;
    }

    public void addDraw(int scored, int conceded) {
        this.points += 1;
        this.goalsScored += scored;
        this.goalsConceded += conceded;
    }

    public void addLoss(int scored, int conceded) {
        this.goalsScored += scored;
        this.goalsConceded += conceded;
    }

    public int getGoalDifference() {
        return goalsScored - goalsConceded;
    }

    @Override
    public int compareTo(CompetitionStats other) {
        if (this.points != other.points) {
            return Integer.compare(this.points, other.points);
        }
        return Integer.compare(this.getGoalDifference(), other.getGoalDifference());
    }
}
