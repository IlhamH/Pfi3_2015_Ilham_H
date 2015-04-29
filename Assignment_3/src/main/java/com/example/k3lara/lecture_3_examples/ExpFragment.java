package com.example.k3lara.lecture_3_examples;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import com.example.k3lara.lecture_3_examples.control.Constants;
import com.example.k3lara.lecture_3_examples.model.Journey;
import com.example.k3lara.lecture_3_examples.model.Journeys;
import com.example.k3lara.lecture_3_examples.xmlparser.Parser;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private ArrayList<Journey> myItems = new ArrayList<Journey>();
    private MyAdapter myAdapter;
    private Spinner sp;
    private Spinner sp2;


    public ExpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_schedule_expandable, container, false);
        ///Do whatever
        ExpandableListView ev = (ExpandableListView) v.findViewById(R.id.expandableListView);
        myAdapter = new MyAdapter(getActivity(),myItems);
        ev.setAdapter(myAdapter);
        //MyAsyncTask myAsyncTask = new MyAsyncTask();
        //myAsyncTask.execute("KD323B-20151-K3522");
        sp = (Spinner)v.findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);

        sp2 = (Spinner)v.findViewById(R.id.spinner2);
        sp2.setOnItemSelectedListener(this);
        return v;
    }

    ///Listens to meny selection.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.i("ExpFragment", "MenuSelection. " + id);
        if (id == R.id.refresh) {
            int i = sp.getSelectedItemPosition();
            String[] sa = getActivity().getResources().getStringArray(R.array.courses);
            String course = sa[i];
            MyAsyncTask myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(course);
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }

    //Listens to the spinner
  @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      int fromNumber = sp.getSelectedItemPosition();
      int toNumber = sp2.getSelectedItemPosition();

            String[] courses = getActivity().getResources().getStringArray(R.array.destination);
            String searchURL = Constants.getURL(courses[fromNumber],courses[toNumber], 10);

      MyAsyncTask myAsyncTask = new MyAsyncTask();
      myAsyncTask.execute(searchURL);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //And the thread
    private class MyAsyncTask extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... params) {
            Journeys journeys = Parser.getJourneys(params[0]);

            myItems.clear();
            myItems.addAll(journeys.getJourneys());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
           myAdapter.notifyDataSetChanged();
            for (Journey si :myItems){
                Log.i("ExpFragment", "moment" + si.getStartStation());
            }
        }
    }
}