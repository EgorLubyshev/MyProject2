package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Records extends AppCompatActivity {
    ListView listView;

    int mistake=0;
    String time;
    boolean[] booleans = new boolean[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);
        listView=findViewById(R.id.listView);
        Intent intent = getIntent();
        mistake=intent.getExtras().getInt("mistakes");
        booleans = intent.getExtras().getBooleanArray ("IsTrue");
        time = intent.getExtras().getString("time");


        final ArrayAdapter<String> adapter;
        final String[] catNames = new String[] {
                String.valueOf(mistake)+String.valueOf (booleans[2])+time,
                "fefe"
        };
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catNames);
        // Привяжем массив через адаптер к ListView
        listView.setAdapter(adapter);

    }


}
