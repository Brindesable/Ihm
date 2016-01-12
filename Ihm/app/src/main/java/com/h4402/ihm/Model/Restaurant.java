package com.h4402.ihm.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 16/12/2015.
 *
 * A restaurant contains the groups of users. It also has a name.
 */
public class Restaurant {
    private List<Group> groups;
    private String name;
    double latitude;
    double longitude;

    /**
     * Constructor
     * @param n name of the restaurant
     */
    public Restaurant(String n, Double lat, Double lon){
        name = n;
        groups = new ArrayList<Group>();
        latitude = lat;
        longitude = lon;
    }

    /**
     * Second constructor
     * @param n name of the restaurant
     * @param g groups already made
     */
    public Restaurant(String n, List<Group> g){
        name = n;
        groups = g;
    }

    /**
     * Groups getter
     * @return groups of the restaurants
     */
    public List<Group> getGroups (){
        return groups;
    }

    /**
     * Add a group to the restaurant
     * @param g group to add
     */
    public void addGroup( Group g){
        groups.add(g);
    }

    /**
     * Delete a group from the restaurant
     * @param g group to remove
     */
    public void deleteGroup( Group g){
        groups.remove(g);
    }

    /**
     * Name getter
     * @return name of the restaurant
     */
    public String getName(){
        return name;
    }

    public Double getLat() { return latitude; }

    public Double getLon() { return longitude; }
}
