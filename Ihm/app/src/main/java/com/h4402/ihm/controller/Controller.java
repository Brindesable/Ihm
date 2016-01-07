package com.h4402.ihm.Controller;

import com.h4402.ihm.Model.Group;
import com.h4402.ihm.Model.Restaurant;
import com.h4402.ihm.Model.User;
import com.h4402.ihm.R;
import com.h4402.ihm.View.GroupJoinView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kilian on 06/01/2016.
 *
 * Static Controller :
 *  - Set the model fixtures
 *  - Join a group
 */
public final class Controller {

    public static List<Restaurant> restaurants;
    public static GroupJoinView currentGroupSelected = null;
    private static Map<Integer,GroupJoinView> groupsJoinView = new HashMap<Integer,GroupJoinView>();

    public Controller(){}

    /**
     * Init model fixtures
     */
    public static void initModel(){
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
        Group group1 = Group.factory("Troopers", listUsersGroup1, "12h15");

        ArrayList<User> listUsersGroup2 = new ArrayList<User>();
        listUsersGroup2.add(user1);
        listUsersGroup2.add(user5);
        Group group2 = Group.factory("Chevalier Jedi", listUsersGroup2, "11h45");

        ArrayList<User> listUsersGroup3 = new ArrayList<User>();
        listUsersGroup3.add(user2);
        listUsersGroup3.add(user4);
        Group group3 = Group.factory("Chevaliers Sith", listUsersGroup3, "12h00");

        // Creating restaurants
        Restaurant resto1 = new Restaurant("Cantina de Mos-Esley");
        resto1.addGroup(group2);
        group2.setRestaurant(resto1);

        Restaurant resto2 = new Restaurant("Self de l'empire");
        resto2.addGroup(group1);
        group1.setRestaurant(resto2);

        Restaurant resto3 = new Restaurant("Cabine du Millenium Condor");
        resto3.addGroup(group3);
        group3.setRestaurant(resto3);

        restaurants = new ArrayList<Restaurant>();
        restaurants.add(resto1);
        restaurants.add(resto2);
        restaurants.add(resto3);
    }

    /**
     * Give the Group view object with its id
     * @param id Group id
     * @param gjv View object
     */
    public static void addGroupJoinView(int id, GroupJoinView gjv){
        groupsJoinView.put(id, gjv);
    }

    /**
     * Set a new current group joined and refresh the view objects
     * @param id Group id
     */
    public static void selectGroupJoinView(int id){

        currentGroupSelected = groupsJoinView.get(id);

        for(Map.Entry<Integer, GroupJoinView> group : groupsJoinView.entrySet()) {
            GroupJoinView gjv = group.getValue();
            Integer idGroup = group.getKey();

            //ImageButton ib = (ImageButton) view.findViewById(R.id.join_button);
            //GradientDrawable bgShape = (GradientDrawable)ib.getBackground();

            if(id == idGroup)
                gjv.join();
            else
                gjv.quit();
        }
    }
}
