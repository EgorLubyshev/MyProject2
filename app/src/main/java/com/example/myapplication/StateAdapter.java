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

        TextView id = (TextView) view.findViewById(R.id.title_id);
        TextView Setid = (TextView) view.findViewById(R.id.Set_id);

        TextView time = (TextView) view.findViewById(R.id.title_time);
        TextView SetTime = (TextView) view.findViewById(R.id.Set_time);
        TextView mistake = (TextView) view.findViewById(R.id.title_mistake);
        TextView mistakeCount = (TextView) view.findViewById(R.id.Set_mistakeCount);
        TextView countCorrect = (TextView) view.findViewById(R.id.title_countCorrect);
        TextView Set_CountCorrect = (TextView) view.findViewById(R.id.Set_countCorrect);

        State state = states.get(position);

        Setid.setText(String.valueOf( state.getId()));
        SetTime.setText( state.getTime());
        mistakeCount.setText(String.valueOf( state.getMistake()));
        Set_CountCorrect.setText( String.valueOf( state.getCountCurrect()));

        return view;
    }
}