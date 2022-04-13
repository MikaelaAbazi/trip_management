package com.example.trip_management.repository;

import com.example.trip_management.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TripRepository extends JpaRepository<Trip,Long> {

}