package com.cabbookingapplication.services;

import com.cabbookingapplication.algorithms.Util;
import com.cabbookingapplication.models.Driver;
import com.cabbookingapplication.models.Location;
import com.cabbookingapplication.models.Passenger;
import com.cabbookingapplication.models.RideDetails;
import com.cabbookingapplication.repository.IRideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RideService implements IRideService {
    @Autowired
    private IPassengerService passengerService;

    @Autowired
    private IDriverService driverService;

    @Autowired
    private IRideRepo rideRepo;

    @Override
    public List<RideDetails> findRide(String passengerEmail, Location source, Location destination) {

        Passenger passenger = passengerService.findUserByEmail(passengerEmail);
        if (passenger == null) {
            throw new NullPointerException("Please register first");
        }
        List<Driver> drivers = driverService.getDrivers();
        this.rideRepo.addRideDetailsList(createRideDetails(passenger, drivers, source, destination));
        return this.rideRepo.getRideDetailsList();
    }

    @Override
    public void chooseRide(String userEmail, String driverEmail) {
        Passenger passenger = passengerService.findUserByEmail(userEmail);
        Driver driver = driverService.findDriverByEmail(driverEmail);
        if (passenger == null || driver == null) {
            throw new NullPointerException("No Passenger or Driver found");
        }
        for (RideDetails rideDetails : this.rideRepo.getRideDetailsList()) {
            if (rideDetails.getDriver().getEmail().equals(driver.getEmail())) {
                driver.setTotalEarning(rideDetails.getRideCost());
                driver.setAvailable(false);
                driver.setLocation(rideDetails.getDestination());
                System.out.println("your ride cost is " + rideDetails.getRideCost());
                return;
            }
        }
    }

    /**
     * Helper method to create a rideDetails
     *
     * @param passenger
     * @param drivers
     * @param source
     * @param destination
     * @return list of {@link  RideDetails}
     */
    private List<RideDetails> createRideDetails(Passenger passenger, List<Driver> drivers, Location source, Location destination) {
        List<RideDetails> rideDetailsList = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.isAvailable() &&
                    Util.findDistance(source, driver.getLocation()) <= 5)
                rideDetailsList.add(createRideDetail(passenger, driver, source, destination));
        }
        rideDetailsList.sort((RideDetails o1, RideDetails o2) -> (int) (o1.getRideCost() - o2.getRideCost()));
        return rideDetailsList;
    }

    /**
     * Creates a {@link RideDetails}
     *
     * @param passenger
     * @param driver
     * @param source
     * @param destination
     * @return {@link RideDetails}
     */
    private RideDetails createRideDetail(Passenger passenger, Driver driver, Location source, Location destination) {
        return new RideDetails(passenger, driver, source, destination);
    }
}
