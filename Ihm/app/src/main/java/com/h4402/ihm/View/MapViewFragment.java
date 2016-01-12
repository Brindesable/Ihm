package com.h4402.ihm.View;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.h4402.ihm.Controller.Controller;
import com.h4402.ihm.Controller.MainActivity;
import com.h4402.ihm.Model.Restaurant;
import com.h4402.ihm.R;

/**
 * Created by Kilian on 09/01/2016.
 */
public class MapViewFragment extends Fragment {

    MapView mapView;
    GoogleMap googleMap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.map_fragment, container, false);
        mapView = (MapView) v.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        final ImageButton buttonBack = (ImageButton) v.findViewById(R.id.back_button);
        buttonBack.setColorFilter(Color.GRAY);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonBack.setColorFilter(Color.parseColor("#2196f3"));
                buttonBack.setBackgroundResource(R.drawable.roundcorner_blue);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonBack.setColorFilter(Color.GRAY);
                        buttonBack.setBackgroundResource(R.drawable.roundcorner_white);
                    }
                }, 500);
                MainActivity.mPager.setCurrentItem(1);
            }
        });

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mapView.getMap();
        // latitude and longitude
        double latitude = 45.782289;
        double longitude = 4.874855;

        for(Restaurant resto : Controller.restaurants){
            // create marker
            MarkerOptions marker = new MarkerOptions().position(
                    new LatLng(resto.getLat(), resto.getLon()))
                    .title(resto.getName())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_logo_bonapp));

            // adding marker
            googleMap.addMarker(marker);
        }

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)).zoom(16).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        // Perform any camera updates here
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
