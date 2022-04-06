package com.cabbookingapplication.models;

import com.cabbookingapplication.Contants.RideStatus;
import com.cabbookingapplication.algorithms.Util;

public class RideDetails {
    Passenger passenger;
    Driver driver;
    Location destination;
    Location source;
    double rideCost;
    double distance;
    RideStatus rideStatus;

    public RideDetails(Passenger passenger, Driver driver,Location source, Location destination) {
        this.passenger = passenger;
        this.driver = driver;
        this.destination = destination;
        this.rideCost = calculateRideCost();
        this.distance = calculateDistance();
        this.source = source;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public double getRideCost() {
        return rideCost;
    }

    private double calculateRideCost() {
        return Util.findDistance(this.passenger.getLocation(), this.driver.getLocation()) * this.driver.getRate();
    }

    private long calculateDistance() {
        return Util.findDistance(this.passenger.getLocation(), this.driver.getLocation());
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public void setRideCost(double rideCost) {
        this.rideCost = rideCost;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "RideDetails{" +
                "passenger=" + passenger +
                ", driver=" + driver +
                ", destination=" + destination +
                ", source=" + source +
                ", rideCost=" + rideCost +
                ", distance=" + distance +
                ", rideStatus=" + rideStatus +
                '}';
    }
}
