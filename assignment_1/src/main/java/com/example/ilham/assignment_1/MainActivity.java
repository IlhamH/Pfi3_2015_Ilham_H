package com.example.ilham.assignment_1;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    TextView t; // variabel för textView

    @Override
    protected void onPostResume() {
        Log.i("myApp", "RESUMED");
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        Log.i("myApp", "PAUSED");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.i("myApp", "DESTROYED");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.i("myApp", "STOPPED");
        super.onStop();
    }

    @Override
    protected void onStart() {
        Log.i("myApp", "STARTED");
        super.onStart();
    }

    public void buttonOnClicked(View v){ // Metod - vad som ska hända när knappen är "clicked"
        Log.i("myAPP", "Button pressed");
        Button b = (Button) findViewById(R.id.nextButton); // Knappen - refererar till specifik knappen
        t = (TextView) findViewById(R.id.textView); // TextView - ref. till specifik textView

        Resources res = getResources(); // Hänvisar till resources mappen?
        String[] Quotes = res.getStringArray(R.array.myQuotes); // Min string array

        t.setText(Quotes[new Random().nextInt(Quotes.length)]); // Här säger man till vad som ska visas på TextView.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        return super.onOptionsItemSelected(item);
    }
}
