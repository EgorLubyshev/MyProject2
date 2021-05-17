package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class lv6 extends AppCompatActivity {

    public TextView c1, c2, c3, c4, a1, a2, a3, a4, textView, check;
    Display display;
    Point size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv3);

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

        a1.setHeight(height/12);
        a2.setHeight(height/12);
        a3.setHeight(height/12);
        a4.setHeight(height/12);
        a1.setWidth(width / 3);
        a2.setWidth(width / 3);
        a3.setWidth(width / 3);
        a4.setWidth(width / 3);

        RandomLoad();

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

    void RandomLoad() {
        TextLoad(textView, 11);
        TextLoad(check, 6);
        textView.setText(String.valueOf(  (int) (Math.random()*5)+1 ));
        Integer[] a = new Integer[4];
        for (int i = 0; i < a.length; i++) {
            a[i] = i+12;
        }
        Collections.shuffle(Arrays.asList(a));
        TextLoad(c1, a[0]);
        TextLoad(c2, a[1]);
        TextLoad(c3, a[2]);
        TextLoad(c4, a[3]);
    }

    void TextLoad(TextView text, int id ){
        TextLoader textLoader = new TextLoader(text, id);
        textLoader.execute("http://192.168.100.5/EgorLubyshev/");
        //textLoader.execute("http://10.67.172.157/EgorLubyshev/");
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
    void check(){
        if (a1.getText().equals("for i in range(7,21,3):") && a2.getText().equals("a+=i") &&
                a3.getText().equals("a=19") && a4.getText().equals("print(a)")){
            Toast.makeText(this, "все верно!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), lv1_s.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT).show();
        }
    }
}