package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StateAdapter extends ArrayAdapter<State> {

    private LayoutInflater inflater;
    private int layout;
    private List<State> states;


    public StateAdapter(Context context, int resource, List<State> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView time = (TextView) view.findViewById(R.id.title_time);
        TextView SetTime = (TextView) view.findViewById(R.id.Set_time);
        TextView mistake = (TextView) view.findViewById(R.id.title_mistake);
        TextView mistakeCount = (TextView) view.findViewById(R.id.Set_mistakeCount);

        State state = states.get(position);


        SetTime.setText( state.getTime());
        mistakeCount.setText(String.valueOf( state.getMistake()));

        return view;
    }
}