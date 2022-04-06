package com.cabbookingapplication.algorithms;


import com.cabbookingapplication.models.Location;

public class Util {

    public static long findDistance(Location a, Location b) {
        int x1 = a.getX();
        int y1 = a.getY();
        int x2 = b.getX();
        int y2 = b.getY();
        return (long) Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

}
