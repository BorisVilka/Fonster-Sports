package com.fonster.sports;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Game {

    @SerializedName("away")
    @Expose
    Team away;

    @SerializedName("home")
    @Expose
    Team home;

    @SerializedName("score")
    @Expose
    String score;

    @SerializedName("time")
    @Expose
    String time;

    @SerializedName("league")
    @Expose
    League league;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
