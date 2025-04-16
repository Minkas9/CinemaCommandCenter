package com.example.CinemaCommandCenter.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String location;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Screening> screenings = new ArrayList<>();
}
