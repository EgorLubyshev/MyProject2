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
import android.widget.Chronometer;
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

public class Menu extends AppCompatActivity {
    TextView title, menu, records, exit;
    Display display;
    Point size;
    Chronometer chronometer;

    int mistake=0;
    String time;
    boolean[] booleans = new boolean[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
       title=findViewById(R.id.title);
       menu=findViewById(R.id.menu);
       records=findViewById(R.id.record);
       exit=findViewById(R.id.exit);
        chronometer=findViewById(R.id.chronometer);
        chronometer.start();

       display = getWindowManager().getDefaultDisplay();
       size = new Point();
       display.getSize(size);
       int width = size.x;
       int height = size.y;

       title.setTextSize(width/25);
       title.setHeight(height/3);

       menu.setTextSize(width/40);
        menu.setHeight(height/6);
       records.setTextSize(width/40);
        records.setHeight(height/6);
       exit.setTextSize(width/40);
        exit.setHeight(height/6);
        time=chronometer.getText().toString();
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("mistake", mistake);
                intent.putExtra("base", chronometer.getBase());
                startActivityForResult(intent, 1);
            }
        });

        records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Records.class);
                intent.putExtra("IsTrue", booleans);
                intent.putExtra("mistakes", mistake);
                intent.putExtra("time", time);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        booleans = data.getExtras().getBooleanArray("IsTrue");
        mistake =  data.getExtras().getInt("mistakes");
        if (booleans[0] && booleans[1] && booleans[2] && booleans[3] &&
                booleans[4] && booleans[5] && booleans[6] && booleans[7] &&
                booleans[8]){

        }
    }

}