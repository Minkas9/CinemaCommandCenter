package com.example.CinemaCommandCenter.controller;

import com.example.CinemaCommandCenter.service.LoyaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/loyalty")
@RequiredArgsConstructor
public class LoyaltyController {

    private final LoyaltyService loyaltyService;

    @GetMapping("/{viewerName}")
    public ResponseEntity<Integer> getLoyaltyPointsByName(@PathVariable String viewerName) {
        return ResponseEntity.ok(loyaltyService.getPoints(viewerName));
    }
}
