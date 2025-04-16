package com.example.CinemaCommandCenter.service;

import com.example.CinemaCommandCenter.event.TicketBookedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TicketEventListener {

    @EventListener
    public void handleTicketBooked(TicketBookedEvent event) {
        System.out.println("🎟️ TicketBookedEvent fired for screeningId " + event.getScreeningId());
    }
}