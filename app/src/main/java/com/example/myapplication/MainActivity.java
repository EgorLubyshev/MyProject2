package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {
    Button lv1,lv2,lv3,lv4,lv5,lv6,lv7,lv8,lv9;
    Display display;
    Point size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1=findViewById(R.id.lv1);
        lv2=findViewById(R.id.lv2);
        lv3=findViewById(R.id.lv3);
        lv4=findViewById(R.id.lv4);
        lv5=findViewById(R.id.lv5);
        lv6=findViewById(R.id.lv6);
        lv7=findViewById(R.id.lv7);
        lv8=findViewById(R.id.lv8);
        lv9=findViewById(R.id.lv9);

        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        lv1.setWidth(width/3);
        lv1.setHeight(height/3);
        lv1.setTextSize(width/25);

        lv2.setWidth(width/3);
        lv2.setHeight(height/3);
        lv2.setTextSize(width/25);

        lv3.setWidth(width/3);
        lv3.setHeight(height/3);
        lv3.setTextSize(width/25);

        lv4.setWidth(width/3);
        lv4.setHeight(height/3);
        lv4.setTextSize(width/25);

        lv5.setWidth(width/3);
        lv5.setHeight(height/3);
        lv5.setTextSize(width/25);

        lv6.setWidth(width/3);
        lv6.setHeight(height/3);
        lv6.setTextSize(width/25);

        lv7.setWidth(width/3);
        lv7.setHeight(height/3);
        lv7.setTextSize(width/25);

        lv8.setWidth(width/3);
        lv8.setHeight(height/3);
        lv8.setTextSize(width/25);

        lv9.setWidth(width/3);
        lv9.setHeight(height/3);
        lv9.setTextSize(width/25);

        lv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lv1.class);
                startActivity(intent);
            }
        });
    }

}