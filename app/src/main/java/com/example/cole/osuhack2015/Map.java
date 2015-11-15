package com.example.cole.osuhack2015;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.widget.Toast;

public class Map extends Activity {
    public static final String PREFS_NAME = "MyPrefsFile";
    boolean[] prefs = new boolean[10]; //saving all the preferences in their respective booleans
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        /*Bundle b = intent.getExtras();
        prefs = b.getBooleanArray("prefs");*/
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean burger = settings.getBoolean("burger", false);

        String boop = "burger: " + burger;
        Toast.makeText(getApplicationContext(),boop, Toast.LENGTH_LONG).show();

    }

}
