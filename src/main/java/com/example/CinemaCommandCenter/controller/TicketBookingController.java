package com.example.CinemaCommandCenter.controller;

import com.example.CinemaCommandCenter.model.TicketBooking;
import com.example.CinemaCommandCenter.service.TicketBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketBookingController {

    private final TicketBookingService ticketBookingService;

    @PostMapping
    public ResponseEntity<TicketBooking> bookTicket(@RequestBody TicketBooking ticketBooking) {
        return ResponseEntity.ok(ticketBookingService.bookTicket(ticketBooking));
    }
}
