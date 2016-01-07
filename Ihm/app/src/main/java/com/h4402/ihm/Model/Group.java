package com.h4402.ihm.Model;

import java.util.List;

/**
 * Created by thomas on 16/12/2015.
 *
 * A group is specific to a restaurant. His main characteristics are the people inside this group
 * and the hour they want to eat.
 */
public class Group {

    private List<User> users;
    private Restaurant resto = null;
    private String name;
    private String hour;
    private int id;

    private static int nextId = 0;

    /**
     * Constructor
     * @param n Name of the group
     * @param g List of Users inside this group
     * @param h Hour they want to eat
     */
    public Group(int i, String n, List<User> g, String h){
        id = i;
        name = n;
        users = g;
        hour = h;
    }

    public static Group factory(String name, List<User> users, String hour){
        return new Group(nextId++, name, users, hour);
    }

    /**
     * User getter
     * @return users inside the group
     */
    public List<User> getUsers (){
        return users;
    }

    /**
     * Add a user inside the group
     * @param u User to add
     */
    public void addUser( User u){
        users.add(u);
    }

    /**
     * Delete a user form the group
     * @param u User to remove
     */
    public void deleteUser( User u){
        users.remove(u);
    }

    /**
     * Name getter
     * @return name of the group
     */
    public String getName(){
        return name;
    }

    /**
     * Hour getter
     * @return hour of the meeting
     */
    public String getHour() { return hour; }

    public int getId(){ return id; }

    public Restaurant getRestaurant(){ return resto; }

    public void setRestaurant(Restaurant r){ resto = r; }
}
