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

public class MainActivity extends AppCompatActivity {
    Button lv1,lv2,lv3,lv4,lv5,lv6,lv7,lv8,lv9;
    TextView select, mis, count, title_points, setPoints;
    Chronometer chronometer;
    Display display;
    Point size;
    int mistake=0, id=999;
    String time;
    int countCurrect=0;
    int points=0;
    boolean[] booleans = {true, true, true, true, true, true, true, true, true};
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
        select=findViewById(R.id.SelectLv);
        mis=findViewById(R.id.mistakeCount);
        count=findViewById(R.id.Count);
        chronometer=findViewById(R.id.chronometer1);
        title_points=findViewById(R.id.points);
        setPoints=findViewById(R.id.Set_points);






        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        chronometer.setTextSize(width/70);
        chronometer.setWidth(width/6);
        chronometer.setHeight(height/16);
        title_points.setTextSize(width/60);
        setPoints.setTextSize(width/60);

        select.setTextSize(width/40);
        mis.setTextSize(width/60);
        count.setTextSize(width/60);

        lv1.setWidth(width/3);
        lv1.setHeight(height/6);
        lv1.setTextSize(width/25);

        lv2.setWidth(width/3);
        lv2.setHeight(height/6);
        lv2.setTextSize(width/25);

        lv3.setWidth(width/3);
        lv3.setHeight(height/6);
        lv3.setTextSize(width/25);

        lv4.setWidth(width/3);
        lv4.setHeight(height/6);
        lv4.setTextSize(width/25);

        lv5.setWidth(width/3);
        lv5.setHeight(height/6);
        lv5.setTextSize(width/25);

        lv6.setWidth(width/3);
        lv6.setHeight(height/6);
        lv6.setTextSize(width/25);

        lv7.setWidth(width/3);
        lv7.setHeight(height/6);
        lv7.setTextSize(width/25);

        lv8.setWidth(width/3);
        lv8.setHeight(height/6);
        lv8.setTextSize(width/25);

        lv9.setWidth(width/3);
        lv9.setHeight(height/6);
        lv9.setTextSize(width/25);

        Intent intent1 = getIntent();
        count.setText(String.valueOf(mistake));
        setPoints.setText(String.valueOf(points));


        chronometer.stop();
        lv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lv1.class);
                intent.putExtra("IsComplited", booleans[0]);

                startActivityForResult(intent, 1);
                chronometer.start();
            }
        });

        lv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lv2.class);
                intent.putExtra("IsComplited", booleans[1]);
                startActivityForResult(intent, 1);
                chronometer.start();
            }
        });

        lv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lv3.class);
                intent.putExtra("IsComplited", booleans[2]);
                startActivityForResult(intent, 1);
                chronometer.start();
            }
        });

        lv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lv4.class);
                intent.putExtra("IsComplited", booleans[3]);
                startActivityForResult(intent, 1);
                chronometer.start();
            }
        });

        lv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lv5.class);
                intent.putExtra("IsComplited", booleans[4]);
                startActivityForResult(intent, 1);
                chronometer.start();
            }
        });

        lv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lv6.class);
                intent.putExtra("IsComplited", booleans[5]);
                startActivityForResult(intent, 1);
                chronometer.start();
            }
        });

        lv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lv7.class);
                intent.putExtra("IsComplited", booleans[6]);
                startActivityForResult(intent, 1);
                chronometer.start();
            }
        });

        lv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lv8.class);
                intent.putExtra("IsComplited", booleans[7]);
                startActivityForResult(intent, 1);
                chronometer.start();

            }
        });

        lv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lv9.class);
                intent.putExtra("IsComplited", booleans[8]);
                startActivityForResult(intent, 1);
                chronometer.start();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("IsTrue", countCurrect);
        intent.putExtra("mistakes", mistake);
        time= chronometer.getText().toString();
        intent.putExtra("time", time);
        setResult(RESULT_OK , intent);
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        id=data.getExtras().getInt("id");
        if (data.getExtras().getBoolean("IsTrue")){
            countCurrect ++;
        }
        mistake +=  data.getExtras().getInt("mistakes");
        count.setText(String.valueOf(mistake));
        setPoints.setText(String.valueOf(points));
        points += data.getExtras().getInt("points");
        switch (id){
            case 0 :
                Intent intent = new Intent(getApplicationContext(), lv2.class);
                booleans[id]=false;
                if (booleans[id+1]) {
                    intent.putExtra("IsComplited", booleans[id+1]);
                }
                startActivityForResult(intent, 1);
                return;
            case 1 :
                intent = new Intent(getApplicationContext(), lv3.class);
                booleans[id]=false;
                if (booleans[id+1]) {
                    intent.putExtra("IsComplited", booleans[id+1]);
                }
                startActivityForResult(intent, 1);
                return;
            case 2 :
                intent = new Intent(getApplicationContext(), lv4.class);
                booleans[id]=false;
                if (booleans[id+1]) {
                    intent.putExtra("IsComplited", booleans[id+1]);
                }
                startActivityForResult(intent, 1);
                return;
            case 3 :
                intent = new Intent(getApplicationContext(), lv5.class);
                booleans[id]=false;
                if (booleans[id+1]) {
                    intent.putExtra("IsComplited", booleans[id+1]);
                }
                startActivityForResult(intent, 1);
                return;
            case 4 :
                intent = new Intent(getApplicationContext(), lv6.class);
                booleans[id]=false;
                if (booleans[id+1]) {
                    intent.putExtra("IsComplited", booleans[id+1]);
                }
                startActivityForResult(intent, 1);
                return;
            case 5 :
                intent = new Intent(getApplicationContext(), lv7.class);
                booleans[id]=false;
                if (booleans[id+1]) {
                    intent.putExtra("IsComplited", booleans[id+1]);
                }
                startActivityForResult(intent, 1);
                return;
            case 6 :
                intent = new Intent(getApplicationContext(), lv8.class);
                booleans[id]=false;
                if (booleans[id+1]) {
                    intent.putExtra("IsComplited", booleans[id+1]);
                }
                startActivityForResult(intent, 1);
                return;
            case 7 :
                intent = new Intent(getApplicationContext(), lv9.class);
                booleans[id]=false;
                if (booleans[id+1]) {
                    intent.putExtra("IsComplited", booleans[id+1]);
                }
                startActivityForResult(intent, 1);
                return;
            case 8 :
                booleans[id]=false;
                return;
            default:

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalDB localDB = new LocalDB(this);
        localDB.insert(chronometer.getText().toString(), countCurrect, mistake, points);
    }
}