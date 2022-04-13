package com.example.trip_management.service.IServices;

import com.example.trip_management.dto.FlightDto;
import com.example.trip_management.model.Trip;

import java.util.List;

public interface ITripService {

    Trip createTrip(Trip trip);

    List<Trip> viewTrips();

    Trip viewTripById(Long id);

    Trip updateTripById(Trip trip,Long id);

    void deleteTripById(Long id);


    List<FlightDto>viewFlights();
}
