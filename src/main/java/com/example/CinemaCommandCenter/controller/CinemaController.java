package com.example.CinemaCommandCenter.controller;

import com.example.CinemaCommandCenter.model.Cinema;
import com.example.CinemaCommandCenter.service.CinemaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cinema")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

    @PostMapping()
    public ResponseEntity<Cinema> addCinema(@RequestBody @Valid Cinema cinema) {
        return ResponseEntity.ok(cinemaService.addCinema(cinema));
    }
}
