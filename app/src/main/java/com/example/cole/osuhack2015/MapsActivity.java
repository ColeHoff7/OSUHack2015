package com.example.cole.osuhack2015;

import android.content.SharedPreferences;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //this is how you get the boolean values for the preferences gathered in the previous screen
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean burger = settings.getBoolean("burger", false);
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng columbus = new LatLng(39.9833, -82.9833);
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.975, -82.9733)).title("Marker in Columbus"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.971, -82.9843)).title("Marker in Columbus"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.983,-82.9913)).title("Marker in Columbus"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(columbus));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(columbus, 11.0f));


    }


}
