package com.cabbookingapplication.services;

import com.cabbookingapplication.Contants.RideStatus;
import com.cabbookingapplication.models.Driver;

import java.util.List;

public interface IDriverService {

    void addDriver(Driver driver);

    void updateDriverLocation(String name, String email, int x, int y);

    void changeDriverStatus(String name, String email, boolean status);

    Driver findDriverByEmail(String driverEmail);

    List<Driver> getDrivers();

    double findTotalEarning();
}
