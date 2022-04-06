package com.cabbookingapplication.services;

import com.cabbookingapplication.models.Passenger;
import com.cabbookingapplication.repository.IPassengerRepo;
import com.cabbookingapplication.validator.PassengerRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PassengerService implements IPassengerService {
    @Autowired
    private IPassengerRepo passengerRepo;

    @Autowired
    private PassengerRequestValidator passengerRequestValidator;

    @Override
    public void addPassenger(Passenger passenger) {
        passengerRepo.addPassenger(passenger);
    }

    @Override
    public void updatePassenger(Passenger oldPassenger, Passenger updatedPassenger) {
        if (passengerRequestValidator.validate(oldPassenger) && passengerRequestValidator.validate(updatedPassenger)) {
            this.passengerRepo.updatePassenger(oldPassenger, updatedPassenger);
        }
    }

    @Override
    public void updatePassengerLocation(String name, String email, int X, int Y) {
        if (passengerRequestValidator.validateUsingEmail(email))
            this.passengerRepo.updatePassengerLocation(name, email, X, Y);
    }

    public Passenger findUserByEmail(String email) {
        if (passengerRequestValidator.validateUsingEmail(email))
            return passengerRepo.findUserByEmail(email);
        else throw new NullPointerException("No Passenger with this email");
    }

    @Override
    public List<Passenger> getAllPassengers() {
        List<Passenger> passengers = this.passengerRepo.getPassengers();
        if (passengers != null) return passengers;
        else throw new NullPointerException("No passenger is registered");
    }
}
