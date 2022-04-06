package com.cabbookingapplication.controller;

import com.cabbookingapplication.models.Passenger;
import com.cabbookingapplication.services.IPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cabApp/api/passenger")
public class PassengerController {

    @Autowired
    private IPassengerService passengerService;

    @PostMapping("add")
    public ResponseEntity<String> addPassenger(@RequestBody Passenger passenger) {
        passengerService.addPassenger(passenger);
        return ResponseEntity.of(Optional.of("success"));
    }

    @PutMapping("update")
    public ResponseEntity<String> updatePassenger(@RequestBody Passenger oldPassenger, @RequestBody Passenger updatedPassenger) {
        this.passengerService.updatePassenger(oldPassenger, updatedPassenger);
        return ResponseEntity.of(Optional.of("update success"));
    }

    @PutMapping("update/location/{name}")
    public ResponseEntity<String>  updatePassengerLocation(@PathVariable("name") String name,
                                                           @RequestParam("email") String email,
                                                           @RequestParam("x") int x,
                                                           @RequestParam("y") int y) {
        this.passengerService.updatePassengerLocation(name, email, x, y);
        return ResponseEntity.of(Optional.of("Passenger's Location updated"));
    }

    @GetMapping("get")
    public ResponseEntity<Passenger> findUserByEmail(@RequestParam("email") String email) {
        Passenger passenger = passengerService.findUserByEmail(email);
        return ResponseEntity.of(Optional.ofNullable(passenger));
    }

    @GetMapping("getAllPassengers")
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return ResponseEntity.of(Optional.ofNullable(passengerService.getAllPassengers()));
    }
}
