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
     * we just add a marker near Columbus, Ohio, USA.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
	double latitude = 39.9833;
	double longitude = -82.9833;

        // Add a marker in Columbus and move the camera
	GPSTracker tracker = new GPSTracker(this);

	// If the location tracker is open (either GPS or WiFi)
	// Returns the current location
	if (tracker.canGetLocation()) {
		latitude = traacker.getLatitude();
		longitude = tracker.getLongitude();
	}
        LatLng columbus = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.975, -82.9733)).title("Marker in Columbus"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.971, -82.9843)).title("Marker in Columbus"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(39.983,-82.9913)).title("Marker in Columbus"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(columbus));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(columbus, 11.0f));


	/*
	 * Use Google Search API
	 * Generate the array
	 * Stores queries based on users' pre-defined preferences
	 * List the top 20 (will support more than 20 at some pt)
	 *
	 * HashMap<K, V> preference = (user_object).getPref();
	 * for (pref : hashmap) {
	 *    $post(pref) => GOogle Search
	 *    $get => geoloc of certain attractions
	 * }
	 *
	 * showResult();
	 *
	 *
	 */

    }

// FURTHER IMPROVEMENTS

    // Some push notification stuff comes here?

}
