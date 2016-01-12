package com.h4402.ihm.Controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.h4402.ihm.R;
import com.sleepbot.datetimepicker.time.RadialPickerLayout;
import com.sleepbot.datetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class AddGroupActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private Spinner spinnerRestaurant;
    public static final String TIMEPICKER_TAG = "timepicker";
    public static AddGroupActivity activity;
    private CheckBox checkboxPermanent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_group_activity);
        activity = this;

        spinnerRestaurant = (Spinner)findViewById(R.id.spinnerRestaurant);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.restaurant_array, R.layout.spinner_restaurant);
        spinnerRestaurant.setAdapter(adapter);

        final EditText groupName = (EditText) findViewById(R.id.editTextNomGroupe);
        Button buttonAdd = (Button) findViewById(R.id.buttonAjouter);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddGroupActivity.activity, "Un nouveau groupe " + groupName.getText() + " vient d'être créé !", Toast.LENGTH_LONG).show();
                AddGroupActivity.activity.finish();
            }
        });

        checkboxPermanent = (CheckBox) findViewById(R.id.checkBoxPermanent);

        checkboxPermanent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    final Calendar calendar = Calendar.getInstance();
                    final TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(AddGroupActivity.activity, calendar.get(Calendar.HOUR_OF_DAY) ,calendar.get(Calendar.MINUTE), false, false);
                    timePickerDialog.setVibrate(false);
                    timePickerDialog.setCloseOnSingleTapMinute(true);
                    timePickerDialog.show(getSupportFragmentManager(), TIMEPICKER_TAG);
                } else {
                    checkboxPermanent.setText("Permanent");
                }
            }
        });
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        checkboxPermanent.setText("Permanent : " + hourOfDay + "h" + minute);
    }
}