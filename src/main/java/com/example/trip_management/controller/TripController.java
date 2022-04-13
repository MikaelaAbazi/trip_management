package com.example.trip_management.controller;


import com.example.trip_management.dto.FlightDto;
import com.example.trip_management.model.Trip;
import com.example.trip_management.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/trip")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @PostMapping("/create")

    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        return new ResponseEntity<Trip>(tripService.createTrip(trip), HttpStatus.CREATED);
    }

    @GetMapping("/viewDto")
    public List<FlightDto>viewFlightsDto(){
        return tripService.viewFlights();
    }

    @GetMapping("/view")

    public List<Trip> viewTrips() {
        return tripService.viewTrips();
    }

    @GetMapping("/view/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<Trip> viewTripById(@PathVariable Long id) {
        return new ResponseEntity<Trip>(tripService.viewTripById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<Trip> updateTripById(@PathVariable("id") Long id, @RequestBody Trip trip) {
        return new ResponseEntity<Trip>(tripService.updateTripById(trip, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<String> deleteTripById(@PathVariable("id") Long id) {
        tripService.deleteTripById(id);
        return new ResponseEntity<String>("Trip Deleted", HttpStatus.OK);
    }

}



