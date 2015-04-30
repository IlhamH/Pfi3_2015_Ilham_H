package com.example.k3lara.lecture_3_examples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.k3lara.lecture_3_examples.model.Journey;
import com.example.k3lara.lecture_3_examples.model.Station;

import java.util.ArrayList;

/**
 * Created by K3LARA on 13/04/2015.
 */
public class MyAdapter extends BaseExpandableListAdapter {
    private ArrayList<Journey> myItems;
        private Context c;

    public MyAdapter(Context c,ArrayList<Journey> myItems){
        this.c=c;
        this.myItems = myItems;
    }

    @Override
    public int getGroupCount() {
        return myItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Journey j = myItems.get(groupPosition);

        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.groupexpl_layout,null);

        TextView Destination = (TextView) convertView.findViewById(R.id.textView_des);
        Station des = myItems.get(groupPosition).getEndStation();
        Destination.setText(des.getStationName());

        TextView Destinaton = (TextView) convertView.findViewById(R.id.Destination);
        Station endStation = myItems.get(groupPosition).getStartStation();
        Destinaton.setText(endStation.getStationName());
/*
        TextView tid_avgang =(TextView) convertView.findViewById(R.id.tid_avgang);
        String noOfChanges = myItems.get(groupPosition).getNoOfChanges();
        tid_avgang.setText(noOfChanges);*/
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.group_child_layout,null);

        Journey journey = myItems.get(groupPosition);


        TextView startStation1 = (TextView) convertView.findViewById(R.id.Startstation1);
        Station startStation = myItems.get(groupPosition).getStartStation();
        startStation1.setText(startStation.getStationName());

        TextView des = (TextView) convertView.findViewById(R.id.Destination);
        Station endStation = myItems.get(groupPosition).getEndStation();
        des.setText(endStation.getStationName());

        TextView Rese_tid = (TextView) convertView.findViewById(R.id.Rese_tid);
        String travelMinutes = myItems.get(groupPosition).getTravelMinutes();
        Rese_tid.setText("Departure in " + travelMinutes + " minutes");
        int timeLeft = Integer.parseInt(travelMinutes);

        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);

        if(timeLeft <= 5 ){
        img.setVisibility(View.VISIBLE);
        }
        else {
            img.setVisibility(View.INVISIBLE);  }

        TextView Forsening = (TextView) convertView.findViewById(R.id.Forsening);
        String depTimeDeviation = myItems.get(groupPosition).getDepTimeDeviation();
            Forsening.setText(depTimeDeviation + " minutes late");

//        int late = Integer.parseInt(depTimeDeviation);
       /* if(late <= 0 ){
            Forsening.setText("On time");
        }
        else
        {
            Forsening.setText(depTimeDeviation + " minutes late");
        }
*/

        return convertView;
    }


    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
