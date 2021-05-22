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

public class lv1 extends AppCompatActivity {

    public TextView variant1, variant2, variant3, variant4,
            answer1, answer2, answer3, answer4, result,check;
    Display display;
    Point size;
    String text;
    ArrayList<Task> tasks = new ArrayList<>();
    ArrayList<String> arrOriginal = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv1);



        result=findViewById(R.id.result);
        check=findViewById(R.id.check);

        variant1=findViewById(R.id.variant1);
        variant2=findViewById(R.id.variant2);
        variant3=findViewById(R.id.variant3);
        variant4=findViewById(R.id.variant4);

        answer1=findViewById(R.id.answer1);
        answer2=findViewById(R.id.answer2);
        answer3=findViewById(R.id.answer3);
        answer4=findViewById(R.id.answer4);



        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        answer1.setWidth(width/4);
        answer2.setWidth(width/4);
        answer3.setWidth(width/4);
        answer4.setWidth(width/4);
        answer1.setHeight(height/12);
        answer2.setHeight(height/12);
        answer3.setHeight(height/12);
        answer4.setHeight(height/12);

        variant1.setWidth(width/2);
        variant2.setWidth(width/2);
        variant3.setWidth(width/2);
        variant4.setWidth(width/2);
        variant1.setHeight(height/12);
        variant2.setHeight(height/12);
        variant3.setHeight(height/12);
        variant4.setHeight(height/12);


        TasksLoader tasksLoader = new TasksLoader();
        tasksLoader.setOnPostExecute(new TasksLoader.OnPostExecute() {
            @Override
            public void doOnPostExecute(TaskAnswer answer) {
                tasks = answer.data;
                arrOriginal=tasks.get(0).variants;
                setTask(tasks.get(0));
            }
        });

        tasksLoader.execute("http://10.148.190.161");

        variant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswer(variant1);
            }
        });
        variant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswer(variant2);
            }
        });
        variant3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswer(variant3);
            }
        });
        variant4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswer(variant4);
            }
        });

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setVariant(answer1);
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){ setVariant(answer2); }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setVariant(answer3);
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setVariant(answer4);
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
        ArrayList<String> arrayList = task.variants;
        Collections.shuffle(arrayList);
        variant1.setText(arrayList.get(0));
        variant2.setText(arrayList.get(1));
        variant3.setText(arrayList.get(2));
        variant4.setText(arrayList.get(3));
        result.setText(task.text);
        if (task.type==1){
            setContentView(R.layout.activity_main);
        }
        if (task.type==2){
            setContentView(R.layout.activity_main);
        }
    }

    void setAnswer(TextView variant){
        if (answer1.getText().equals("")){
            answer1.setText(variant.getText());
            variant.setVisibility(View.INVISIBLE);
        }else {
            if(answer2.getText().equals("")){
                answer2.setText(variant.getText());
                variant.setVisibility(View.INVISIBLE);
            }else {
                if (answer3.getText().equals("")){
                    answer3.setText(variant.getText());
                    variant.setVisibility(View.INVISIBLE);
                }else {
                    if(answer4.getText().equals("")) {
                        answer4.setText(variant.getText());
                        variant.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }
    }
    void setVariant( TextView answer){
        if (answer.getText().equals(variant1.getText())){
            variant1.setVisibility(View.VISIBLE);
            answer.setText("");
        }
        if (answer.getText().equals(variant2.getText())){
            variant2.setVisibility(View.VISIBLE);
            answer.setText("");
        }
        if (answer.getText().equals(variant3.getText())){
            variant3.setVisibility(View.VISIBLE);
            answer.setText("");
        }
        if (answer.getText().equals(variant4.getText())){
            variant4.setVisibility(View.VISIBLE);
            answer.setText("");
        }
    }
    void check() {
        if (    answer1.getText().equals(arrOriginal.get(0)) &&
                answer2.getText().equals(arrOriginal.get(1)) &&
                answer3.getText().equals(arrOriginal.get(2)) &&
                answer4.getText().equals(arrOriginal.get(3))) {
            Toast.makeText(this, "все верно!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), lv2.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT).show();
        }
    }

}