package com.example.CinemaCommandCenter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "cinemaId")
    private Cinema cinema;

    @NotBlank(message = "Movie title is required")
    private String movieTitle;

    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;

    @NotNull(message = "Available seats count is required")
    @Min(value = 0, message = "Available seats cannot be negative")
    private Integer availableSeats;
}
