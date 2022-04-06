package com.cabbookingapplication.services;

import com.cabbookingapplication.models.Passenger;

import java.util.List;

public interface IPassengerService {

    void addPassenger(Passenger passenger);

    void updatePassenger(Passenger oldPassenger, Passenger updatedPassenger);

    void updatePassengerLocation(String name, String email, int X, int Y);

    Passenger findUserByEmail(String email);

    List<Passenger> getAllPassengers();
}
