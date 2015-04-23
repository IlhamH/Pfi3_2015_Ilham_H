package com.example.ilham.lecture_4_examples_adapter_extra;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import se.mah.k3.lecture_4_examples_adapter_extra.R;

public class FragmentInfo extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.planet_info, container, false);
        planetClass p = (planetClass) getArguments().getSerializable("planet");

        TextView tv_title = (TextView) v.findViewById(R.id.tv_dialog_title);
        ImageView iv = (ImageView) v.findViewById(R.id.iv_dialog);
        TextView tv_temp = (TextView) v.findViewById(R.id.tv_Temp);
        TextView tv_description = (TextView) v.findViewById(R.id.tv_dialog_description);
        TextView tv_radius = (TextView) v.findViewById(R.id.tv_Radius);


        tv_title.setText(p.getTitle());
        tv_temp.setText("Temp: " + p.getTemp());
        tv_radius.setText("Radius: " + p.getRadius());
        tv_description.setText(p.getSummary());
        iv.setImageDrawable(p.getImage());
        return v;
    }



}
