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

    int mistake=0;
    String time;
    boolean[] booleans = new boolean[9];
    ArrayList<State> states = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);
        listView=findViewById(R.id.listView);
        Intent intent = getIntent();
        mistake=intent.getExtras().getInt("mistakes");
        booleans = intent.getExtras().getBooleanArray ("IsTrue");
        time = intent.getExtras().getString("time");

        setInitialData();
        // получаем элемент ListView
        listView = (ListView) findViewById(R.id.listView);
        // создаем адаптер
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_adapter, states);
        // устанавливаем адаптер
        ListView.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                State selectedState = (State)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getMistake(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        listView.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){

       states.add(new State(mistake, time  ,booleans));
    }


}
