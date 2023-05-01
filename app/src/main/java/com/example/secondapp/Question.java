package com.example.secondapp;

public class Question {
    private String titleQuestion;
    private boolean answer;
    private int points;

    public Question(String titleQuestion, boolean answer) {
        this.titleQuestion = titleQuestion;
        this.answer = answer;
    }

    public Question(String titleQuestion, boolean answer, int points) {
        this.titleQuestion = titleQuestion;
        this.answer = answer;
        this.points = points;
    }

    public String getTitleQuestion() {
        return titleQuestion;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
