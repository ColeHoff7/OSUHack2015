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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout;
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

        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.prefLayout);
        //rl.setOrientation(RelativeLayout.VERTICAL);
        /*food = new CheckBox(this);
        food.setText("Food");
        rl.addView(food);

        night = new CheckBox(this);
        night.setText("Night Life");
        rl.addView(night);*/

       // listener(rl);
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

    /*public void listener(final RelativeLayout rl){
        //food = (CheckBox) findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is food checked?
                if (((CheckBox) v).isChecked()) {
                    //Toast.makeText(InitialPreferences.this, "Food Added", Toast.LENGTH_LONG).show();
                    foodClick(rl);
                }

            }
        });
    }*/

    public void foodClick(RelativeLayout rl){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 100;
        params.addRule(RelativeLayout.BELOW, food.getId());
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        CheckBox burger = new CheckBox(this);
        burger.setText("Burgers");
        rl.addView(burger, params);

    }
}
