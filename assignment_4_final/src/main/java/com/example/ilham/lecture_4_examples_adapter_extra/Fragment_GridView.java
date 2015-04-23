package com.example.ilham.lecture_4_examples_adapter_extra;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import se.mah.k3.lecture_4_examples_adapter_extra.R;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class Fragment_GridView extends Fragment {
   public static ArrayList<planetClass> books = new ArrayList<planetClass>();

    //This method comes first so lets create the books here
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        books.clear();
        Drawable d = getResources().getDrawable(R.drawable.mercury);
        books.add(new planetClass("Mercury",d));
        d = getResources().getDrawable(R.drawable.venus);
        books.add(new planetClass("Venus",d));
        d = getResources().getDrawable(R.drawable.earth);
        books.add(new planetClass("Earth",d));
        d = getResources().getDrawable(R.drawable.mars);
        books.add(new planetClass("Mars",d));
        d = getResources().getDrawable(R.drawable.jupiter);
        books.add(new planetClass("Jupiter",d));
        d = getResources().getDrawable(R.drawable.uranus);
        books.add(new planetClass("Uranus",d));
        d = getResources().getDrawable(R.drawable.saturn);
        books.add(new planetClass("Saturn",d));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_with_list, container, false);
        Log.i("FragmentWithList","NumberOfBooks: " + books.size());
        ImgAdapter la = new ImgAdapter(getActivity(),books);
        GridView lv = (GridView) v.findViewById(R.id.gridView);
        lv.setAdapter(la);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("FragmentWithList", "Clicked on position: " + position);

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.main_layout, new FragmentDialog());
                ft.addToBackStack(null);
                ft.commit();



/*                FragmentManager fm = getFragmentManager();
                FragmentDialog fd = new FragmentDialog();
                Bundle b = new Bundle();
                b.putSerializable("book",books.get(position));
                fd.setArguments(b);
                fd.show(fm,"Dialog");*/
            }
        });
        return v;
    }


}
