package com.cabbookingapplication.services;

import com.cabbookingapplication.models.Driver;
import com.cabbookingapplication.models.Location;
import com.cabbookingapplication.models.Passenger;
import com.cabbookingapplication.models.RideDetails;

import java.util.List;

public interface IRideService {

    /**
     * Finds the nearest ride from the service
     *
     * @param passengerEmail
     * @param source
     * @param destination
     * @return
     */
    List<RideDetails> findRide(String passengerEmail, Location source, Location destination);

    /**
     * Selects a ride for Passenger based on given driverEmail
     *
     * @param userEmail
     * @param driverEmail
     */
    void chooseRide(String userEmail, String driverEmail);
}
