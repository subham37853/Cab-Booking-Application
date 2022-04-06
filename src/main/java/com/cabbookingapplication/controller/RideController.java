package com.cabbookingapplication.controller;

import com.cabbookingapplication.models.*;
import com.cabbookingapplication.services.IRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cabApp/api/rides")
public class RideController {

    @Autowired
    IRideService rideService;

    @PostMapping("/findRide/{passengerEmail}")
    public ResponseEntity<List<RideDetails>> findRide(@PathVariable("passengerEmail") String passengerEmail,
                                                      @RequestBody RideRequestDetails rideRequestDetails) {
        List<RideDetails> rides = rideService.findRide(passengerEmail, rideRequestDetails.getSource(), rideRequestDetails.getDestination());
        return ResponseEntity.of(Optional.ofNullable(rides));
    }

    @PostMapping("/choseRide/{userEmail}/{driverEmail}")
    public ResponseEntity<String> chooseRide(@PathVariable("userEmail") String userEmail, @PathVariable("driverEmail") String driverEmail) {
        rideService.chooseRide(userEmail, driverEmail);
        return ResponseEntity.of(Optional.of("Ride has been started"));
    }
}
