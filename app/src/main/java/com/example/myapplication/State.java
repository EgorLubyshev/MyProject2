package com.example.myapplication;

import java.io.Serializable;

class State implements Serializable {
    int id;
    int mistake;
    String time;
    int countCurrect;
    int points;

    State(int mistake, String time, int countCurrect, int id, int points ){
        this.countCurrect=countCurrect;
        this.mistake=mistake;
        this.time=time;
        this.id=id;
        this.points=points;

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMistake() {
        return mistake;
    }

    public String getTime() {
        return time;
    }

    public int getCountCurrect() {
        return countCurrect;
    }

    public void setMistake(int mistake) {
        this.mistake = mistake;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountCurrect(int countCurrect) {
        this.countCurrect = countCurrect;
    }
}