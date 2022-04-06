package com.cabbookingapplication.services;

import com.cabbookingapplication.models.Passenger;

import java.util.List;

public interface IPassengerService {

    /**
     * Adds a passenger to the system
     *
     * @param passenger
     */
    void addPassenger(Passenger passenger);

    /**
     * updates the existing passenger with new details
     *
     * @param oldPassenger
     * @param updatedPassenger
     */
    void updatePassenger(Passenger oldPassenger, Passenger updatedPassenger);

    /**
     * Updates the location of an existing passenger
     *
     * @param name
     * @param email
     * @param X
     * @param Y
     */
    void updatePassengerLocation(String name, String email, int X, int Y);

    /**
     * Finds an existing passenger by Email.
     *
     * @param email
     * @return
     */
    Passenger findUserByEmail(String email);

    /**
     * Gives the details of all the existing passengers.
     *
     * @return
     */
    List<Passenger> getAllPassengers();
}
