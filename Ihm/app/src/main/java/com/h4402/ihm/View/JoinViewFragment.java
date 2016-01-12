package com.h4402.ihm.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.h4402.ihm.Controller.AddGroupActivity;
import com.h4402.ihm.Controller.Controller;
import com.h4402.ihm.Controller.InscriptionActivity;
import com.h4402.ihm.Controller.JoinGroupHourActivity;
import com.h4402.ihm.Model.Group;
import com.h4402.ihm.Model.Restaurant;
import com.h4402.ihm.Model.User;
import com.h4402.ihm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kilian on 05/01/2016.
 */
public class JoinViewFragment extends Fragment {

    private LinearLayout joinViewGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.join_view, container, false);

        LinearLayout joinViewRestaurantsList = (LinearLayout) view.findViewById(R.id.listRestaurants);
        JoinViewRestaurantsList viewRestos = new JoinViewRestaurantsList(getContext(), joinViewRestaurantsList);
        viewRestos.setRestaurants(Controller.restaurants);

        RelativeLayout rl = (RelativeLayout) inflater.inflate(R.layout.join_view_add_group, container, false);
        joinViewRestaurantsList.addView(rl);
        final ImageButton ib = (ImageButton)  rl.findViewById(R.id.add_button);
        ib.setColorFilter(Color.GRAY);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AddGroupActivity.class);
                context.startActivity(intent);
                ib.setColorFilter(Color.parseColor("#2196f3"));
                ib.setBackgroundResource(R.drawable.roundcorner_blue);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ib.setColorFilter(Color.GRAY);
                        ib.setBackgroundResource(R.drawable.roundcorner_white);
                    }
                }, 500);
            }
        });

        return view;
    }
}
