package com.h4402.ihm.Controller;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RemoteViews;

import com.google.android.gms.maps.GoogleMap;
import com.h4402.ihm.R;
import com.h4402.ihm.View.FriendViewFragment;
import com.h4402.ihm.View.JoinViewFragment;
import com.h4402.ihm.View.MapViewFragment;

import java.util.ResourceBundle;

// https://romannurik.github.io/AndroidAssetStudio/icons-generic.html

/**
 *
 */
public class MainActivity extends FragmentActivity {

    private static final int NUM_ITEMS = 3;
    MyAdapter mAdapter;
    static public ViewPager mPager;
    public static FragmentManager fragmentManager;
    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activity = this;

        // Launch splashscreen
        Intent intent = new Intent(this, SplashScreenActivity.class);
        startActivity(intent);

        setContentView(R.layout.fragment_pager);
        Controller.initModel();

        fragmentManager = getSupportFragmentManager();

        // Instantiate a ViewPager and a PagerAdapter.
        mAdapter = new MyAdapter(getSupportFragmentManager());
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(1);

        // Change bar color
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.GRAY);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN && Controller.currentGroupSelected != null){
            Controller.sendNotif(this);
        }

        return true;
    }

    public static class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new FriendViewFragment();
            } else if(position == 1) {
                return new JoinViewFragment();
            } else {
                return new MapViewFragment();
            }
        }
    }
}
