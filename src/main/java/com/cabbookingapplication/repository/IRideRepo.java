package com.cabbookingapplication.repository;

import com.cabbookingapplication.models.RideDetails;

import java.util.List;


public interface IRideRepo {

    /**
     * Returns the List of {@link RideDetails}
     *
     * @return
     */
    List<RideDetails> getRideDetailsList();

    /**
     * Adds to the {@link RideDetails} list
     * @param rideDetailsList
     */
    void addRideDetailsList(List<RideDetails> rideDetailsList);
}
