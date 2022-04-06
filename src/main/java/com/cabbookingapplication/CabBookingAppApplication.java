package com.cabbookingapplication;

import com.cabbookingapplication.Contants.Gender;
import com.cabbookingapplication.models.Driver;
import com.cabbookingapplication.models.Passenger;
import com.cabbookingapplication.services.IDriverService;
import com.cabbookingapplication.services.IPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class CabBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingAppApplication.class, args);

	}

	@Component
	private class DriverRunner implements CommandLineRunner {

		@Autowired
		IPassengerService passengerService;

		@Autowired
		IDriverService driverService;

		@Override
		public void run(String... args) throws Exception {

			Passenger passenger = new Passenger("Shubham Prasad", "subham@gmail.com", Gender.MALE, 22, 0, 0);
			Driver d1 = new Driver("Abishek Prasad", "abi@gmail.com", Gender.MALE, 33, "SWIFT", "WB-123", 5, 1, 2);
			Driver d2 = new Driver("Biswas Prasad", "biswas@gmail.com", Gender.MALE, 23, "DESIRE", "JH-123", 7, 2, 3);
			Driver d3 = new Driver("Pintu Prasad", "pp@gmail.com", Gender.MALE, 28, "VERNA", "WB-444", 6, 5, 8);

			passengerService.addPassenger(passenger);

			Arrays.asList(d1, d2, d3)
					.forEach(driverService :: addDriver);

			System.out.println("Executed!!!");
		}
	}

}
