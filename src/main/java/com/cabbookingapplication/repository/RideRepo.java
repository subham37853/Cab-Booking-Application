package com.cabbookingapplication.repository;

import com.cabbookingapplication.models.RideDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold the {@link RideDetails}, used as an in memory DB
 */
@Repository
public class RideRepo implements IRideRepo {
    private List<RideDetails> rideDetailsList = new ArrayList<>();

    @Override
    public List<RideDetails> getRideDetailsList() {
        return rideDetailsList;
    }

    @Override
    public void addRideDetailsList(List<RideDetails> rideDetailsList) {
        this.rideDetailsList = rideDetailsList;
    }
}
