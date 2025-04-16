package com.example.CinemaCommandCenter.controller;

import com.example.CinemaCommandCenter.model.Screening;
import com.example.CinemaCommandCenter.service.ScreeningService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/screening")
@RequiredArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;

    @PostMapping("/{cinemaId}")
    public ResponseEntity<Screening> addScreening(
            @RequestBody @Valid Screening screening,
            @PathVariable Long cinemaId) {
        return ResponseEntity.ok(screeningService.addScreening(screening, cinemaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable Long id) {
        return ResponseEntity.ok(screeningService.getScreeningById(id));
    }
}
