package com.example.CinemaCommandCenter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Long screeningId;

    @NotBlank
    private String viewerName;

    @NotBlank
    private Integer seatCount;


    private LocalDateTime bookingTime;

}
