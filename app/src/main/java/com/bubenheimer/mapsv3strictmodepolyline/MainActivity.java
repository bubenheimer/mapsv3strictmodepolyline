package com.bubenheimer.mapsv3strictmodepolyline;

import android.os.Bundle;
import android.os.StrictMode;

import com.google.android.libraries.maps.GoogleMap;
import com.google.android.libraries.maps.OnMapReadyCallback;
import com.google.android.libraries.maps.SupportMapFragment;
import com.google.android.libraries.maps.model.LatLng;
import com.google.android.libraries.maps.model.PolylineOptions;

import androidx.appcompat.app.AppCompatActivity;

public final class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.setThreadPolicy(
                new StrictMode.ThreadPolicy.Builder()
                        .detectCustomSlowCalls()
                        .penaltyDeath()
                        .build());

        setContentView(R.layout.activity_main);

        final SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().getFragments().get(0);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.addPolyline(new PolylineOptions().add(new LatLng(0.0, 1.0)));
            }
        });
    }
}
