package com.h4402.ihm.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.h4402.ihm.R;

/**
 * Created by Kilian on 09/01/2016.
 */
public class InscriptionActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.inscription_activity);

        View.OnTouchListener listenerQuit = new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                finish();
                return false;
            }
        };

        Button inscriptionButton = (Button) findViewById(R.id.inscription_button);
        inscriptionButton.setOnTouchListener(listenerQuit);
        ImageView fbButton = (ImageView) findViewById(R.id.facebook_button);
        fbButton.setOnTouchListener(listenerQuit);
        ImageView googleButton = (ImageView) findViewById(R.id.google_button);
        googleButton.setOnTouchListener(listenerQuit);
    }
}
