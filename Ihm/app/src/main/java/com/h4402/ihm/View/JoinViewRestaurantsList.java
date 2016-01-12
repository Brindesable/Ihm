package com.h4402.ihm.View;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.h4402.ihm.Model.Restaurant;
import com.h4402.ihm.R;

import java.util.List;

/**
 * Created by Kilian on 07/01/2016.
 */
public class JoinViewRestaurantsList {

    private Context context;
    private LinearLayout viewRestaurants;

    JoinViewRestaurantsList(Context c, LinearLayout ll){
        context = c;
        viewRestaurants = ll;
    }

    public void setRestaurants(List<Restaurant> restos){

        for(Restaurant resto : restos) {
            if(resto.getGroups().size() > 0) {
                CardView restoView = (CardView) LayoutInflater.from(context).inflate(R.layout.join_view_restaurant, viewRestaurants, false);
                // Lookup view for data population
                TextView restaurantName = (TextView) restoView.findViewById(R.id.restaurant_name);
                // Set the restaurant name
                restaurantName.setText(resto.getName());
                // Then set the groups inside
                LinearLayout groupsContainer = (LinearLayout) restoView.findViewById(R.id.group_container);
                JoinViewGroupsList viewGroups = new JoinViewGroupsList(context, groupsContainer);

                viewGroups.setGroups(resto.getGroups());

                viewRestaurants.addView(restoView);
            }
        }
    }
}
