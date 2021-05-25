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
        states=localDB.selectAll();

        listView=findViewById(R.id.listView);
        Intent intent = getIntent();
        mistake=intent.getExtras().getInt("mistakes");
        countCurrect = intent.getExtras().getInt ("IsTrue");
        time = intent.getExtras().getString("time");

        setInitialData();
        listView = (ListView) findViewById(R.id.listView);
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_adapter, states);
        listView.setAdapter(stateAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                State selectedState = (State)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getMistake(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        listView.setOnItemClickListener(itemListener);
    }


    private void setInitialData(){

       states.add(new State(mistake, time  ,countCurrect, 1));
        states.add(new State(mistake, time  ,countCurrect, 2));
        states.add(new State(mistake, time  , countCurrect, 3));
        states.add(new State(mistake, time  ,countCurrect, 2));
        states.add(new State(mistake, time  ,countCurrect, 2));
    }


}
