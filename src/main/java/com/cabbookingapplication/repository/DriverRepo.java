package com.cabbookingapplication.repository;


import com.cabbookingapplication.models.Driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold the {@link Driver} details, used as an in memory DB
 */
@Repository
public class DriverRepo implements IDriverRepo {
    private List<Driver> drivers = new ArrayList<>();

    public List<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (this.drivers.contains(driver)) return;
        this.drivers.add(driver);
    }

    @Override
    public void updateDriverLocation(String name, String email, int X, int Y) {
        for (Driver eachDriver : this.drivers) {
            if (eachDriver.getFullName().equals(name) && eachDriver.getEmail().equals(email)) {
                eachDriver.getLocation().setX(X);
                eachDriver.getLocation().setY(Y);
                System.out.println("Updated " + name + "'s" + " location");
                return;
            }
        }
        System.out.println("No Driver found with this name!");
    }

    @Override
    public void changeDriverStatus(String name, String email, boolean status) {
        for (Driver driver : this.drivers) {
            if (driver.getFullName().equals(name) && driver.getEmail().equals(email)) {
                driver.setAvailable(status);
                System.out.println("Changed the status Successfully!");
                return;
            }
        }
        System.out.println("No Driver found with this name and email");
    }

    @Override
    public Driver findDriverByName(String driverEmail) {
        return drivers.stream()
                .filter(driver -> driver.getEmail().equals(driverEmail))
                .findFirst()
                .orElse(null);
    }

    @Override
    public double findTotalEarning() {
        double sum = 0;
        for (Driver driver : drivers) {
            sum += driver.getTotalEarning();
        }
        return sum;
    }
}
