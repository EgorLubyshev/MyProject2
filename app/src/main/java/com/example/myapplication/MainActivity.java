package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
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

    public TextView c1, c2, c3, c4, a1, a2, a3, a4, textView, textView2 ,check;
    Display display;
    Point size;
    String text;
    ArrayList<Task> tasks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv1);



        textView=findViewById(R.id.text_view1);
        check=findViewById(R.id.check);

        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);

        a1=findViewById(R.id.answer1);
        a2=findViewById(R.id.answer2);
        a3=findViewById(R.id.answer3);
        a4=findViewById(R.id.answer4);



        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        a1.setWidth(width/4);
        a2.setWidth(width/4);
        a3.setWidth(width/4);
        a4.setWidth(width/4);

        c1.setWidth(width/4);
        c2.setWidth(width/4);
        c3.setWidth(width/4);
        c4.setWidth(width/4);

        TasksLoader tasksLoader = new TasksLoader();
        tasksLoader.setOnPostExecute(new TasksLoader.OnPostExecute() {
            @Override
            public void doOnPostExecute(TaskAnswer answer) {
                tasks = answer.data;
                setTask(tasks.get(0));
            }
        });

        tasksLoader.execute("http://10.148.190.161");

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c(c1);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c(c2);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               c(c3);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c(c4);
            }
        });

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ans(a1);
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ans(a2);
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ans(a3);
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ans(a4);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });

    }

    void setTask(Task task){
        c1.setText(task.variants.get(0));
        c2.setText(task.variants.get(1));
        c3.setText(task.variants.get(2));
        c4.setText(task.variants.get(3));
        textView.setText(task.text);
        if (task.type==1){
            setContentView(R.layout.activity_main);
        }
        if (task.type==2){
            setContentView(R.layout.activity_main);
        }
    }

    void c(TextView c){
        if (a1.getText().equals("")){
            a1.setText(c.getText());
            c.setVisibility(View.INVISIBLE);
        }else {
            if(a2.getText().equals("")){
                a2.setText(c.getText());
                c.setVisibility(View.INVISIBLE);
            }else {
                if (a3.getText().equals("")){
                    a3.setText(c.getText());
                    c.setVisibility(View.INVISIBLE);
                }else {
                    if(a4.getText().equals("")) {
                        a4.setText(c.getText());
                        c.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }
    }
    void ans( TextView answer){
        if (answer.getText().equals(c1.getText())){
            c1.setVisibility(View.VISIBLE);
            answer.setText("");
        }
        if (answer.getText().equals(c2.getText())){
            c2.setVisibility(View.VISIBLE);
            answer.setText("");
        }
        if (answer.getText().equals(c3.getText())){
            c3.setVisibility(View.VISIBLE);
            answer.setText("");
        }
        if (answer.getText().equals(c4.getText())){
            c4.setVisibility(View.VISIBLE);
            answer.setText("");
        }
    }
    void check() {
        if (a1.getText().equals("print") && a2.getText().equals("(") &&
                (a3.getText().equals("\"Hello World!\"")) || (a3.getText().equals("Hello World!"))
                && a4.getText().equals(")")) {
            Toast.makeText(this, "все верно!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), lv2.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT).show();
        }
    }

}