package com.h4402.ihm.View;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

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
    private static List<Restaurant> restaurants;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.join_view, container, false);

        // Creating people manually
        User user1 = new User("Luke Skywalker", R.drawable.av6);
        User user2 = new User("Kylo Ren", R.drawable.av4);
        User user3 = new User("Finn", R.drawable.av7);
        User user4 = new User("Dark Vador", R.drawable.av5);
        User user5 = new User("Obi-Wan Kenobi", R.drawable.av8);
        User user6 = new User("Stormtrooper", R.drawable.av9);

        // Creating groups manually
        ArrayList<User> listUsersGroup1 = new ArrayList<User>();
        listUsersGroup1.add(user3);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        listUsersGroup1.add(user6);
        Group group1 = new Group("Troopers", listUsersGroup1, "12h15");

        ArrayList<User> listUsersGroup2 = new ArrayList<User>();
        listUsersGroup2.add(user1);
        listUsersGroup2.add(user5);
        Group group2 = new Group("Chevalier Jedi", listUsersGroup2, "11h45");

        ArrayList<User> listUsersGroup3 = new ArrayList<User>();
        listUsersGroup3.add(user2);
        listUsersGroup3.add(user4);
        Group group3 = new Group("Chevaliers Sith", listUsersGroup3, "12h00");

        // Creating restaurants
        Restaurant resto1 = new Restaurant("Cantina de Mos-Esley");
        resto1.addGroup(group2);

        Restaurant resto2 = new Restaurant("Self de l'empire");
        resto2.addGroup(group3);
        resto2.addGroup(group1);

        Restaurant resto3 = new Restaurant("Cabine du Faucon Millenium");
        resto3.addGroup(group2);
        resto3.addGroup(group3);

        restaurants = new ArrayList<Restaurant>();
        restaurants.add(resto1);
        restaurants.add(resto2);
        restaurants.add(resto3);

        ListView joinViewRestaurantsList = (ListView) view.findViewById(android.R.id.list);
        JoinViewAdapter joinViewRestaurantsListAdapter = new JoinViewAdapter(getContext(), restaurants);
        joinViewRestaurantsList.setAdapter(joinViewRestaurantsListAdapter);

        return view;
    }
}
