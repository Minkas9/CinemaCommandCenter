package com.example.CinemaCommandCenter.service;

import com.example.CinemaCommandCenter.event.TicketBookedEvent;
import com.example.CinemaCommandCenter.model.TicketBooking;
import com.example.CinemaCommandCenter.repository.TicketBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TicketBookingService {

    private final TicketBookingRepository ticketBookingRepository;
    private final ApplicationEventPublisher publisher;

    public TicketBooking bookTicket(TicketBooking ticketBooking) {
        ticketBooking.setBookingTime(LocalDateTime.now());
        ticketBookingRepository.save(ticketBooking);
        publisher.publishEvent(new TicketBookedEvent(
                this,
                ticketBooking.getScreeningId(),
                ticketBooking.getSeatCount(),
                ticketBooking.getViewerName()
        ));
        return ticketBooking;
    }
}
