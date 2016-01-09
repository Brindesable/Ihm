package com.h4402.ihm.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.h4402.ihm.R;

/**
 * Created by Kilian on 09/01/2016.
 */
public class SplashScreenActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;
    private static Activity activity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        activity = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Inscription
                Intent intent = new Intent(SplashScreenActivity.activity, InscriptionActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
