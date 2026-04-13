package model;

import java.time.LocalDate;


public class Attempt {
    private String username;
    private int score;
    private String date;

    public Attempt(String username, int score) {
        this.username = username;
        this.score = score;
        this.date = LocalDate.now().toString();
    }


    public String getUsername() {
        return username;
    }
    public int getScore() {
        return score;
    }
    public String getDate() {
        return date;
    }




}
