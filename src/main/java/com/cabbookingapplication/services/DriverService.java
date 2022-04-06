package com.cabbookingapplication.services;


import com.cabbookingapplication.Contants.RideStatus;
import com.cabbookingapplication.models.Driver;
import com.cabbookingapplication.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService implements IDriverService {
    @Autowired
    private DriverRepo driverRepo;

    @Override
    public void addDriver(Driver driver) {
        driverRepo.addDriver(driver);
    }

    @Override
    public void updateDriverLocation(String name, String email, int x, int y) {
        driverRepo.updateDriverLocation(name, email, x, y);
    }

    @Override
    public void changeDriverStatus(String name, String email, boolean status) {
        driverRepo.changeDriverStatus(name, email, status);
    }

    @Override
    public Driver findDriverByEmail(String driverEmail) {
        return driverRepo.findDriverByName(driverEmail);
    }

    @Override
    public List<Driver> getDrivers() {
        return driverRepo.getDrivers();
    }

    @Override
    public double findTotalEarning() {
        return this.driverRepo.findTotalEarning();
    }
}
