package com.example.CinemaCommandCenter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @JoinColumn(name="cinemaId")
    private Cinema cinema;

    @NotBlank
    private String movieTitle;
    private LocalDateTime startTime;
    private Integer availableSeats;
}
