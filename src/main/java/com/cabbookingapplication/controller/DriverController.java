package com.cabbookingapplication.controller;

import com.cabbookingapplication.models.Driver;
import com.cabbookingapplication.services.IDriverService;
import com.cabbookingapplication.validator.DriverValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cabApp/api/driver")
public class DriverController {

    @Autowired
    private IDriverService driverService;

    @Autowired
    DriverValidator driverValidator;

    @PostMapping("add")
    public ResponseEntity<String> addDriver(@RequestBody Driver driver) {
        if (driverValidator.validate(driver)){
            driverService.addDriver(driver);
            return ResponseEntity.of(Optional.of("Driver Successfully Added!"));
        }
        throw new IllegalArgumentException("Wrong Object");
    }

    @PutMapping("update/location/{name}")
    public ResponseEntity<String> updateDriverLocation(@PathVariable("name") String name,
                                               @RequestParam(value = "email", required = true) String email,
                                               @RequestParam(value = "x", required = true) int x,
                                               @RequestParam(value = "y", required = true) int y) {
        if (driverValidator.validateByEmail(email)){
            driverService.updateDriverLocation(name, email, x, y);
            return ResponseEntity.of(Optional.of("Update Successful!"));
        }
        throw new NullPointerException("No driver found with these details");
    }

    @PutMapping(value = "update/status/{name}")
    public ResponseEntity<String> changeDriverStatus(@PathVariable("name") String name,
                                   @RequestParam(value = "email", required = true) String email,
                                   @RequestParam(value = "status", required = true) boolean status) {
        if (driverValidator.validateByEmail(email)) {
            driverService.changeDriverStatus(name, email, status);
            return ResponseEntity.of(Optional.of("Status Change Successful!"));
        }
        throw new NullPointerException("No driver found");
    }

    @GetMapping("find/")
    public Driver findDriverByEmail(String driverEmail) {
        Driver driverByEmail = driverService.findDriverByEmail(driverEmail);
        if (driverValidator.validate(driverByEmail)) {
            return driverByEmail;
        }
        throw new NullPointerException("There is no driver registered with this email");
    }

    @GetMapping("get")
    public List<Driver> getDrivers() {
        List<Driver> drivers = driverService.getDrivers();
        if (drivers.size() != 0) return drivers;
        throw new NullPointerException("No drivers registered");
    }


    @GetMapping("total/earnings")
    public double findTotalEarning() {
        return driverService.findTotalEarning();
    }
}
