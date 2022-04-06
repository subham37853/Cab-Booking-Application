package com.cabbookingapplication.repository;

import com.cabbookingapplication.models.Driver;
import com.cabbookingapplication.models.Passenger;

import java.util.List;

public interface IPassengerRepo {

    /**
     *  Insert {@link Passenger} details to DB.
     *
     * @param passenger
     */
    void addPassenger(Passenger passenger);

    /**
     * Update the {@link Passenger} details in the DB.
     *
     * @param oldPassenger
     * @param updatedPassenger
     */
    void updatePassenger(Passenger oldPassenger, Passenger updatedPassenger);

    /**
     * Update {@link Passenger} {@link Location} details
     *
     * @param name
     * @param email
     * @param x
     * @param y
     */
    void updatePassengerLocation(String name, String email, int x, int y);

    /**
     * Finds the {@link Passenger} by using {@code email}
     *
     * @param email
     * @return Passenger
     */
    Passenger findUserByEmail(String email);

    List<Passenger> getPassengers();
}
