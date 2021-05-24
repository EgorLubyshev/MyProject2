package com.example.myapplication;

import java.io.Serializable;

public class Statistics implements Serializable {

    private int mistakeСount;
    private int time;

    public Statistics (int mistakeСount,int time) {
       this.mistakeСount=mistakeСount;
       this.time=time;
    }

    public int getCount() {
        return mistakeСount;
    }

    public int getTime() {
        return time;
    }
}