package com.cabbookingapplication.validator;

import com.cabbookingapplication.models.Passenger;
import com.cabbookingapplication.repository.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassengerRequestValidator implements IValidator<Passenger>{

    @Autowired
    private LocationValidator locationValidator;

    @Autowired
    private PassengerRepo passengerRepo;

    @Override
    public boolean validate(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Passenger Details Cannot be Null");
        }

        if (passenger.getFullName() == null || passenger.getEmail() == null
            || passenger.getGender() == null || locationValidator.validate(passenger.getLocation())) {
            throw new IllegalArgumentException("Missing passenger fields");
        }

        return true;
    }

    public boolean validateUsingEmail(String email) {
        for (Passenger passenger : passengerRepo.getPassengers()) {
            if (passenger.getEmail().equals(email)) return true;
        }
        throw new NullPointerException("No passenger found with this email");
    }
}
