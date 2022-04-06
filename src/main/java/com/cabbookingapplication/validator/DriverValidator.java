package com.cabbookingapplication.validator;

import com.cabbookingapplication.models.Driver;
import com.cabbookingapplication.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverValidator implements IValidator<Driver>{
    @Autowired
    LocationValidator locationValidator;

    @Autowired
    DriverRepo driverRepo;

    @Override
    public boolean validate(Driver driver) {
        if (driver == null || driver.getEmail() == null
                || driver.getFullName() == null
                || driver.getGender() == null
                || driver.getVehicleDetails() == null
                || !locationValidator.validate(driver.getLocation())) {
            throw new IllegalArgumentException("Details are not correct");
        }
        return true;
    }

    public boolean validateByEmail(String email) {
        for (Driver driver : this.driverRepo.getDrivers()) {
            if (driver.getEmail().equals(email)) return true;
        }
        throw new NullPointerException("No Driver found!");
    }
}
