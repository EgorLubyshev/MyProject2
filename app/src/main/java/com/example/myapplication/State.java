package com.example.myapplication;

import java.io.Serializable;

class State implements Serializable {
    int id;
    int mistake;
    String time;
    boolean[] booleans;

    State(int mistake, String time, boolean[] booleans, int id ){
        this.booleans=booleans;
        this.mistake=mistake;
        this.time=time;
        this.id=id;

    }

    public boolean[] getBooleans() {
        return booleans;
    }

    public int getMistake() {
        return mistake;
    }

    public String getTime() {
        return time;
    }


    public void setBooleans(boolean[] booleans) {
        this.booleans = booleans;
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
}