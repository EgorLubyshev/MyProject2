package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Records extends AppCompatActivity {
    ListView listView;

    int mistake;
    String time;
    int countCurrect;
    ArrayList<State> states = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);

        LocalDB localDB = new LocalDB(this);
        states = localDB.selectAll();

        listView=findViewById(R.id.listView);



        listView = (ListView) findViewById(R.id.listView);

        Collections.sort(states, new Comparator<State>() {
            @Override
            public int compare(State o1, State o2) {
                return o2.getId() - o1.getId();
            }
        });
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_adapter, states);
        listView.setAdapter(stateAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                State selectedState = (State)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getId(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        listView.setOnItemClickListener(itemListener);
    }





}
