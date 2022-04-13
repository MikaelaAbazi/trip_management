package com.example.trip_management.model;

import com.example.trip_management.model.enums.TripReason;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String tripDescription;

    @Column(nullable = false)
    private String fromLocation;

    @Column(nullable = false)
    private String toLocation;

    @Column(nullable = false)
    private String departureDate;

    @Column(nullable = false)
    private String arrivalDate;


    @Enumerated(EnumType.STRING)
    private TripReason tripReason;
}
