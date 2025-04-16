package com.example.CinemaCommandCenter.controller;

import com.example.CinemaCommandCenter.dto.ScreeningAnalyticsDTO;
import com.example.CinemaCommandCenter.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/screening/{id}")
    public ResponseEntity<ScreeningAnalyticsDTO> getAnalytics(@PathVariable Long id) {
        return ResponseEntity.ok(analyticsService.getScreeningAnalytics(id));
    }
}
