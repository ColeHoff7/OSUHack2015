package com.example.cole.osuhack2015;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class InitialPreferences extends Activity {

    public static final String PREFS_NAME = "MyPrefsFile";
    boolean[] prefs = new boolean[10]; //saving all the preferences in their respective booleans

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_preferences);
        Intent intent = getIntent();

        SharedPreferences pref = getSharedPreferences(PREFS_NAME, 0);
        listener();

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar wirl
        // automaticarly handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void listener(){
        CheckBox burger = (CheckBox) findViewById(R.id.burger);
        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    itemClick(0,true);
                }
                else{
                    itemClick(0,false);
                }
            }
        });

        CheckBox cafe = (CheckBox) findViewById(R.id.cafe);
        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    itemClick(1,true);
                }
                else{
                    itemClick(1,false);
                }
            }
        });

        CheckBox chinese = (CheckBox) findViewById(R.id.chinese);
        chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    itemClick(2, true);
                } else {
                    itemClick(2, false);
                }
            }
        });

        CheckBox deli = (CheckBox) findViewById(R.id.deli);
        deli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    itemClick(3, true);
                } else {
                    itemClick(3, false);
                }
            }
        });

        CheckBox mexican = (CheckBox) findViewById(R.id.mexican);
        mexican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    itemClick(4, true);
                } else {
                    itemClick(4, false);
                }
            }
        });

        CheckBox arcade = (CheckBox) findViewById(R.id.arcade);
        arcade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    itemClick(5, true);
                } else {
                    itemClick(5, false);
                }
            }
        });

        CheckBox art = (CheckBox) findViewById(R.id.art);
        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    itemClick(6, true);
                } else {
                    itemClick(6, false);
                }
            }
        });

        CheckBox casinos = (CheckBox) findViewById(R.id.casinos);
        casinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    itemClick(7, true);
                } else {
                    itemClick(7, false);
                }
            }
        });

        CheckBox festivals = (CheckBox) findViewById(R.id.festivals);
        festivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    itemClick(8, true);
                } else {
                    itemClick(8, false);
                }
            }
        });

        CheckBox museums = (CheckBox) findViewById(R.id.museums);
        museums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    itemClick(9, true);
                } else {
                    itemClick(9, false);
                }
            }
        });
    }

    public void itemClick(int i, boolean b){
        prefs[i] = b;
        //Toast.makeText(getApplicationContext(),"toasty", Toast.LENGTH_LONG).show();
    }

    public void submitData(View view){
        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences pref = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("burger", prefs[0]);
        editor.putBoolean("cafe", prefs[1]);
        editor.putBoolean("chinese", prefs[2]);
        editor.putBoolean("deli", prefs[3]);
        editor.putBoolean("mexican", prefs[4]);
        editor.putBoolean("arcade", prefs[5]);
        editor.putBoolean("art", prefs[6]);
        editor.putBoolean("casinos", prefs[7]);
        editor.putBoolean("festivals", prefs[8]);
        editor.putBoolean("museums", prefs[9]);

        // Commit the edits!
        editor.commit();
        /*Bundle b = new Bundle();
        b.putBooleanArray("prefs",prefs);
        i.putExtras(b);*/
        Intent i = new Intent(this, Map.class);
        startActivity(i);
    }
}
