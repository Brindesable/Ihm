package com.h4402.ihm.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.h4402.ihm.R;

public class AddGroupActivity extends AppCompatActivity {

    private Spinner spinnerRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_group_activity);

        spinnerRestaurant = (Spinner)findViewById(R.id.spinnerRestaurant);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.restaurant_array, R.layout.spinner_restaurant);
        spinnerRestaurant.setAdapter(adapter);
    }
}