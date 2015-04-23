package com.example.ilham.lecture_4_examples_adapter_extra;


import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.mah.k3.lecture_4_examples_adapter_extra.R;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragmentDialog extends DialogFragment implements View.OnClickListener {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_app, container, false);
        v.setOnClickListener(this);
/*        Spinner spinner = (Spinner)v.findViewById(R.id.spinner_book_names);
        spinner.setOnItemSelectedListener(this); //This class implements OnItemSelectedListenr
        Spinner spinner2 = (Spinner)v.findViewById(R.id.spinner_other_book_names);
        ArrayAdapter<planetClass> bookAdapter = new ArrayAdapter<planetClass>(this.getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                Fragment_GridView.books);
        spinner2.setAdapter(bookAdapter);
        spinner2.setOnItemSelectedListener(this);*/
        return v;
    }


    //public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
/*            if (parent.getId()==R.id.spinner_book_names){
                String[] bookNames = getResources().getStringArray(R.array.books);
                Log.i("FragmentWithSpinners","Selected position:  "+position+" and book item " +  bookNames[position]);
                Toast.makeText(this.getActivity(),"Selected position:  "+position+" and book item " +  bookNames[position],Toast.LENGTH_LONG).show();
            }

            if (parent.getId()==R.id.spinner_other_book_names){
                String[] isbn_numbers = getResources().getStringArray(R.array.books_isbn);
                Log.i("FragmentWithSpinners","Selected position:  "+position+" with title " +  Fragment_GridView.books.get(position).getNameOfPlanets());
                Toast.makeText(this.getActivity(),"Selected position:  "+position+" with title " +  Fragment_GridView.books.get(position).getNameOfPlanets(),Toast.LENGTH_LONG).show();
            }*/
    //}


/*    public void onNothingSelected(AdapterView<?> parent) {

    }*/

    @Override
    public void onClick(View view) {
        FragmentDialog.this.dismiss();
        {

        }
    }}