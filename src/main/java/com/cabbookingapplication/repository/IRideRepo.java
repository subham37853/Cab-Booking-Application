package com.cabbookingapplication.repository;

import com.cabbookingapplication.models.RideDetails;

import java.util.List;


public interface IRideRepo {

    List<RideDetails> getRideDetailsList();

    void addRideDetailsList(List<RideDetails> rideDetailsList);
}
