package com.h4402.ihm.View;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.h4402.ihm.Controller.Controller;
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

        CardView cv = (CardView) inflater.inflate(R.layout.join_view_add_group, container, false);
        joinViewRestaurantsList.addView(cv);
        ((ImageButton)  cv.findViewById(R.id.add_button)).setColorFilter(Color.GRAY);

        return view;
    }
}
