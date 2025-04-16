package com.example.CinemaCommandCenter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Screening ID is required")
    private Long screeningId;

    @NotBlank(message = "Viewer name is required")
    @Size(min = 2, max = 100, message = "Viewer name must be between 2 and 100 characters")
    private String viewerName;

    @NotNull(message = "Seat count is required")
    @Min(value = 1, message = "Must book at least 1 seat")
    private Integer seatCount;

    private LocalDateTime bookingTime;
}
