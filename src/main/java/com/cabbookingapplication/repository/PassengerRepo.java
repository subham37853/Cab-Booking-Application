package com.cabbookingapplication.repository;

import com.cabbookingapplication.models.Passenger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold the {@link Passenger} details, used as an in memory DB
 */
@Repository
public class PassengerRepo implements IPassengerRepo {
    private final List<Passenger> passengers = new ArrayList<>();

    @Override
    public void addPassenger(Passenger passenger) {
        if (this.passengers.contains(passenger)) return;
        passengers.add(passenger);
    }

    @Override
    public void updatePassenger(Passenger oldPassenger, Passenger updatedPassenger) {
        for (Passenger passenger : this.passengers) {
            if (passenger.equals(oldPassenger)) {
                this.passengers.remove(oldPassenger);
                this.passengers.add(updatedPassenger);
                System.out.println("Passenger details updated");
                return;
            }
        }
        System.out.println("No passenger found");
    }

    @Override
    public void updatePassengerLocation(String name, String email, int x, int y) {
        for (Passenger passenger : passengers) {
            if (passenger.getFullName().equals(name) &&
                passenger.getEmail().equals(email)) {
                passenger.getLocation().setX(x);
                passenger.getLocation().setY(y);
                System.out.println("Passenger location updated");
                return;
            }
        }
        System.out.println("No passenger found");
    }

    @Override
    public Passenger findUserByEmail(String email) {
        return passengers.stream()
                .filter(passenger -> passenger.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Passenger> getPassengers() {
        return this.passengers;
    }
}
