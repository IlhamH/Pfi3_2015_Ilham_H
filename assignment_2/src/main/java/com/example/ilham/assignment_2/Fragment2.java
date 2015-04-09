package com.example.ilham.assignment_2;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment implements View.OnClickListener{
// för att få knappen att fungera - få metoden OnClick..

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        View ImgButton = v.findViewById(R.id.imageView);
        ImgButton.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment1 F1 = new Fragment1();
        ft.replace(R.id.MyMain, F1);
        ft.commit();
    }
}
