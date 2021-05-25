package com.example.myapplication;

class State {
    int mistake;
    String time;
    boolean[] booleans;

    State(int mistake, String time, boolean[] booleans ){
        this.booleans=booleans;
        this.mistake=mistake;
        this.time=time;

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
}