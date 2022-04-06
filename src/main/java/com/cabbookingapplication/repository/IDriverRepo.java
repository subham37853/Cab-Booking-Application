package com.cabbookingapplication.repository;

import com.cabbookingapplication.models.Driver;

public interface IDriverRepo {

    /**
     *  Insert {@link Driver} details to DB.
     *
     * @param driver
     */
    void addDriver(Driver driver);

    /**
     * Updates the {@link Driver}s {@link com.cabbookingapplication.models.Location}
     *
     * @param name
     * @param email
     * @param X
     * @param Y
     */
    void updateDriverLocation(String name, String email, int X, int Y);

    /**
     * Changes the status of {@link Driver}
     *
     * @param name
     * @param email
     * @param status
     */
    void changeDriverStatus(String name, String email, boolean status);

    /**
     * Fetch the {@link Driver} from the Repository
     *
     * @param driverEmail
     * @return Driver
     */
    Driver findDriverByName(String driverEmail);

    /**
     * Returns the total earning done by all the {@link Driver}s available in the system
     *
     * @return total earnings
     */
    double findTotalEarning();
}
