package com.h4402.ihm.Controller;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

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
    public static List<User> friends;
    public static User me;
    public static GroupJoinView currentGroupSelected = null;
    private static Map<Integer,GroupJoinView> groupsJoinView = new HashMap<Integer,GroupJoinView>();

    public Controller(){}

    /**
     * Init model fixtures
     */
    public static void initModel(){
        // Creating people manually
        me = new User("Gabriel Lemoign", R.drawable.ic_user2);
        User user2 = new User("Alonzo Turmoil", R.drawable.ic_user1);
        User user3 = new User("Alfred Leroux", R.drawable.ic_user3);
        User user4 = new User("Antoine Kosmonot", R.drawable.ic_user4);
        User user5 = new User("Pierre Bogos", R.drawable.ic_user5);
        User user6 = new User("Karim Sandoux", R.drawable.ic_user6);
        User user7 = new User("Daniel Labavoine", R.drawable.ic_user7);
        User user8 = new User("Gonzalo Ferra", R.drawable.ic_user8);
        User user9 = new User("Pedro Garz", R.drawable.ic_user9);
        User user10 = new User("Luc Angevin", R.drawable.ic_user10);
        User user11 = new User("Andrew Wild", R.drawable.ic_user11);
        User user12 = new User("Fabio Capello", R.drawable.ic_user12);
        User user13 = new User("Kevin Journet", R.drawable.ic_user13);
        User user14 = new User("Pierre-Alain Maillet", R.drawable.ic_user14);
        User user15 = new User("Julie Patti", R.drawable.ic_user15);
        User userG = new User("Guillaume Kheng", R.drawable.ic_guillaume);
        User userR = new User("Romain Mathonat", R.drawable.ic_romain);

        friends = new ArrayList<User>();
        friends.add(userR);
        friends.add(userG);
        friends.add(user2);
        friends.add(user2);
        friends.add(user5);
        friends.add(user6);
        friends.add(user13);

        // Creating groups manually
        ArrayList<User> listUsersGroup1 = new ArrayList<User>();
        listUsersGroup1.add(user2);
        listUsersGroup1.add(user3);
        listUsersGroup1.add(user4);
        listUsersGroup1.add(user5);
        Group group1 = Group.factory("Équipe AS", listUsersGroup1, "12h15");

        ArrayList<User> listUsersGroup2 = new ArrayList<User>();
        listUsersGroup2.add(user5);
        listUsersGroup2.add(user6);
        listUsersGroup2.add(user7);
        listUsersGroup2.add(user8);
        listUsersGroup2.add(user9);
        listUsersGroup2.add(user10);
        listUsersGroup2.add(user11);
        listUsersGroup2.add(user12);
        Group group2 = Group.factory("Famille INSA", listUsersGroup2, "11h45");

        ArrayList<User> listUsersGroup3 = new ArrayList<User>();
        listUsersGroup3.add(user13);
        listUsersGroup3.add(user14);
        listUsersGroup3.add(user15);
        Group group3 = Group.factory("Insaquatic", listUsersGroup3, "12h00");

        ArrayList<User> listUsersGroup4 = new ArrayList<User>();
        listUsersGroup4.add(userR);
        listUsersGroup4.add(userG);
        Group group4 = Group.factory("Hexanôme", listUsersGroup4, "12h30");

        // Creating restaurants
        Restaurant resto1 = new Restaurant("Castor & Pollux", 45.781040, 4.873571);
        resto1.addGroup(group4);
        group4.setRestaurant(resto1);

        Restaurant resto2 = new Restaurant("L'Olivier", 45.783996, 4.874882);
        resto2.addGroup(group1);
        group1.setRestaurant(resto2);

        Restaurant resto3 = new Restaurant("Resto U", 45.780726, 4.876432);
        resto3.addGroup(group3);
        group3.setRestaurant(resto3);

        Restaurant resto4 = new Restaurant("Ninkasi", 45.778836, 4.872807);
        group2.setRestaurant(resto4);
        resto4.addGroup(group2);

        Restaurant resto5 = new Restaurant("Prévert", 45.781090, 4.873094);
        Restaurant resto6 = new Restaurant("Le Grillon", 45.783873, 4.875067);

        restaurants = new ArrayList<Restaurant>();
        restaurants.add(resto1);
        restaurants.add(resto2);
        restaurants.add(resto3);
        restaurants.add(resto4);
        restaurants.add(resto5);
        restaurants.add(resto6);
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

    public static void sendNotif(Context context){

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.av1)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        .setAutoCancel(true);

        RemoteViews contentView = new RemoteViews(context.getPackageName(), R.layout.notification);
        //contentView.setImageViewResource(R.id.image, R.drawable.ic_launcher);
        contentView.setTextViewText(R.id.resto, Controller.currentGroupSelected.getGroup().getRestaurant().getName());
        contentView.setTextViewText(R.id.group, Controller.currentGroupSelected.getGroup().getName());

        mBuilder.setContent(contentView);

        Intent resultIntent = new Intent(context, RecapActivity.class);

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);

        // Sets an ID for the notification
        int mNotificationId = 1;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
}
