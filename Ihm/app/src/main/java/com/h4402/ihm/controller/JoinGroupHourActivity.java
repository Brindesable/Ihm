package com.h4402.ihm.Controller;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.h4402.ihm.R;

import org.florescu.android.rangeseekbar.RangeSeekBar;

/**
 * Created by Kilian on 06/01/2016.
 */
public class JoinGroupHourActivity extends Activity {

    private static Activity activity = null;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.join_group_hour_view);

        TextView groupName = (TextView) findViewById(R.id.group_name);
        final TextView hour = (TextView) findViewById(R.id.hour);

        groupName.setText("Rejoindre : " + Controller.currentGroupSelected.getGroup().getName());

        RangeSeekBar seekBar = (RangeSeekBar) findViewById(R.id.rangebar);
        seekBar.setRangeValues(0, 12);
        seekBar.setNotifyWhileDragging(true);
        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Object minValue, Object maxValue) {

                Integer min = (Integer) minValue;
                Integer max = (Integer) maxValue;

                Integer hourMin;
                Integer minuteMin;
                Integer hourMax;
                Integer minuteMax;

                minuteMin = (min % 4) * 15;
                hourMin = (min - min % 4) / 4 + 11;

                minuteMax = (max % 4) * 15;
                hourMax = (max - max % 4) / 4 + 11;

                String minuteMaxString = (minuteMax == 0) ? minuteMax.toString() + "0" : minuteMax.toString();
                String minuteMinString = (minuteMin == 0) ? minuteMin.toString() + "0" : minuteMin.toString();

                hour.setText(hourMin.toString() + "h" + minuteMinString + " à "
                    + hourMax.toString() + "h" + minuteMaxString);
            }
        });

        final ImageButton ib = (ImageButton) findViewById(R.id.join_button);
        ib.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ib.setColorFilter(Color.RED);
                JoinGroupHourActivity.activity.finish();
                return false;
            }
        });
    }
}