# Cab-Booking-Application

## Functionality

### Passengers (who will book rides in the application)
#### Here are some functionalities of a Passenger
1. addPassenger: This adds a user to the system through a json body.
2. updatePassenger: This updates the details of an existing passenger.
3. updatePassengerLocation: This updates the location of an existing passenger.

### Drivers (who will have vehicles)
#### Here are some functionalities of a Driver.
1. addDriver: This adds a driver (with all of his details in a json a body) in the system.
2. updateDriverLocation: This updates the location of the driver. 
3. updateDriverStatus: This changes the driver's status to Available or Not Available for a ride.

### Rides
#### This is a functionality for all the passengers. Here we have several functions.
1. findRide: This lets a passenger to find a ride from a source to destination. The function will list out all the drivers who are available and are 5 units away from the source. The list will be sorted based on the pricing.
2. chooseRide: Out of the many available rides from the function "findRide". A passenger can choose which ride we want.
3. findTotalEarning: **This is an admin specific feature** it gives an outputs the sum of all the earnings earned by all the drivers in the application.

### Information for the Viewer
1. This is scalable with minimal changes to the code. 
2. The functions are written in such a manner that it is **Unit Testable** as well.


## Here are the response of the important APIs.

```
List of All the Drivers 
[
    {
        "fullName": "Abishek Prasad",
        "email": "abi@gmail.com",
        "gender": "MALE",
        "age": 33,
        "location": {
            "x": 1,
            "y": 2
        },
        "vehicleDetails": {
            "name": "SWIFT",
            "platNumber": "WB-123"
        },
        "rate": 5.0,
        "totalEarning": 0.0,
        "available": true
    },
    {
        "fullName": "Biswas Prasad",
        "email": "biswas@gmail.com",
        "gender": "MALE",
        "age": 23,
        "location": {
            "x": 2,
            "y": 3
        },
        "vehicleDetails": {
            "name": "DESIRE",
            "platNumber": "JH-123"
        },
        "rate": 7.0,
        "totalEarning": 0.0,
        "available": true
    },
    {
        "fullName": "Pintu Prasad",
        "email": "pp@gmail.com",
        "gender": "MALE",
        "age": 28,
        "location": {
            "x": 5,
            "y": 8
        },
        "vehicleDetails": {
            "name": "VERNA",
            "platNumber": "WB-444"
        },
        "rate": 6.0,
        "totalEarning": 0.0,
        "available": true
    }
]
```

```
API : addPassenger():

curl --location --request POST 'http://localhost:8080/cabApp/api/passenger/add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "fullName": "Anish Prasad",
    "email": "anish@gmail.com",
    "gender": "MALE",
    "age": 28,
    "location": {
        "x": 5,
        "y": 4
    }
}'

Response:
success
```
```
API: findRide():

curl --location --request POST 'http://localhost:8080/cabApp/api/rides/findRide/subham@gmail.com' \
--header 'Content-Type: application/json' \
--data-raw '{
    "source" : {
        "x" : 1,
        "y" : 1
    },
    "destination" : {
        "x" : 5,
        "y" : 8
    }
}'

Response:
[
    {
        "passenger": {
            "fullName": "Shubham Prasad",
            "email": "subham@gmail.com",
            "gender": "MALE",
            "age": 22,
            "location": {
                "x": 0,
                "y": 0
            }
        },
        "driver": {
            "fullName": "Abishek Prasad",
            "email": "abi@gmail.com",
            "gender": "MALE",
            "age": 33,
            "location": {
                "x": 1,
                "y": 2
            },
            "vehicleDetails": {
                "name": "SWIFT",
                "platNumber": "WB-123"
            },
            "rate": 5.0,
            "totalEarning": 0.0,
            "available": true
        },
        "destination": {
            "x": 5,
            "y": 8
        },
        "source": {
            "x": 1,
            "y": 1
        },
        "rideCost": 10.0,
        "distance": 2.0,
        "rideStatus": null
    },
    {
        "passenger": {
            "fullName": "Shubham Prasad",
            "email": "subham@gmail.com",
            "gender": "MALE",
            "age": 22,
            "location": {
                "x": 0,
                "y": 0
            }
        },
        "driver": {
            "fullName": "Biswas Prasad",
            "email": "biswas@gmail.com",
            "gender": "MALE",
            "age": 23,
            "location": {
                "x": 2,
                "y": 3
            },
            "vehicleDetails": {
                "name": "DESIRE",
                "platNumber": "JH-123"
            },
            "rate": 7.0,
            "totalEarning": 0.0,
            "available": true
        },
        "destination": {
            "x": 5,
            "y": 8
        },
        "source": {
            "x": 1,
            "y": 1
        },
        "rideCost": 21.0,
        "distance": 3.0,
        "rideStatus": null
    }
]
```
```
API: chooseRide(): 

curl --location --request POST 'http://localhost:8080/cabApp/api/rides/choseRide/subham@gmail.com/abi@gmail.com'

selected driver's 
    name: Abishek Prasad
    email: abi@gmail.com
Passenger' Details:
    name: Shubham Prasad
    email: subham@gmail.com

Response:
Ride has been started

// This api will make the availability of Abishek false (which is unavailable).
```
