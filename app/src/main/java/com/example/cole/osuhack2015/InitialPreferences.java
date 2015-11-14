package com.example.cole.osuhack2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;


public class InitialPreferences extends Activity {

    CheckBox food;
    CheckBox night;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_preferences);
        Intent intent = getIntent();

        final LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        ll.setOrientation(LinearLayout.VERTICAL);
        food = new CheckBox(this);
        food.setText("Food");
        ll.addView(food);

        night = new CheckBox(this);
        night.setText("Night Life");
        ll.addView(night);

        listener(ll);
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

    public void listener(final LinearLayout ll){
        //CheckBox food = (CheckBox) findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is food checked?
                if (((CheckBox) v).isChecked()) {
                    //Toast.makeText(InitialPreferences.this, "Food Added", Toast.LENGTH_LONG).show();
                    foodClick(ll);
                }

            }
        });
    }

    public void foodClick(LinearLayout ll){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 100;

        CheckBox burger = new CheckBox(this);
        burger.setText("Burgers");
        ll.addView(burger, params);

    }
}
