package com.example.ilham.lecture_4_examples_adapter_extra;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ilham.lecture_4_examples_adapter_extra.FragmentSpinners;
import com.example.ilham.lecture_4_examples_adapter_extra.Fragment_GridView;

import se.mah.k3.lecture_4_examples_adapter_extra.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.main_layout, new Fragment_GridView());
            ft.addToBackStack(null); // not enough, creat a method
            ft.commit();
        }
    }
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_spinner) {
            FragmentManager fm = getFragmentManager();
            FragmentSpinners fd = new FragmentSpinners();
            Bundle b = new Bundle();
            fd.setArguments(b);
            fd.show(fm,"Dialog");
/*            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.main_layout,new FragmentSpinners());
            ft.addToBackStack(null);
            ft.commit();
            return false;*/
        }

        return super.onOptionsItemSelected(item);
    }
}
