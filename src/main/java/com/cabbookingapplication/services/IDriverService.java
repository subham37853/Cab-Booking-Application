package com.cabbookingapplication.services;

import com.cabbookingapplication.Contants.RideStatus;
import com.cabbookingapplication.models.Driver;

import java.util.List;

public interface IDriverService {

    /**
     * Adds a driver to the system.
     *
     * @param driver
     */
    void addDriver(Driver driver);

    /**
     * Updates the location of existing passenger with new location
     * @param name
     * @param email
     * @param x
     * @param y
     */
    void updateDriverLocation(String name, String email, int x, int y);

    /**
     * Updates the availability status of a driver
     *
     * @param name
     * @param email
     * @param status
     */
    void changeDriverStatus(String name, String email, boolean status);

    /**
     * Finds an existing driver using email
     *
     * @param driverEmail
     * @return
     */
    Driver findDriverByEmail(String driverEmail);

    /**
     * Returns the list of all the existing drivers.
     *
     * @return
     */
    List<Driver> getDrivers();

    /**
     * Returns the sum of total earning of all the drivers in the system.
     *
     * @return
     */
    double findTotalEarning();
}
