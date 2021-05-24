package com.example.myapplication;

import java.io.Serializable;

public class Statistics implements Serializable {

    public static int mistakeСount=0;
    public static int time;
    Statistics(){}

    public int getCount() {
        return mistakeСount;
    }

    public int getTime() {
        return time;
    }
}