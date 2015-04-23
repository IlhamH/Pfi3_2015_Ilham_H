package com.example.ilham.lecture_4_examples_adapter_extra;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import se.mah.k3.lecture_4_examples_adapter_extra.R;

/**
 * Created by K3LARA on 20/04/2015.
 */
public class ImgAdapter extends ArrayAdapter<planetClass> {
    ArrayList<planetClass> booksList;
    Context c;

    public ImgAdapter(Context context, ArrayList<planetClass> booksList) {
        super(context, 0, booksList);
        this.booksList = booksList;
        this.c = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("MyListAdapter", "Called for position: " + position);
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.grid_item,null);
        planetClass b = booksList.get(position);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_title);
        ImageView iv = (ImageView) convertView.findViewById(R.id.iv_bookcover);
        tv.setText(b.getTitle());
        iv.setImageDrawable(b.getImage());
        return convertView;
    }
}
