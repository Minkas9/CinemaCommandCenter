package com.example.CinemaCommandCenter.service;

import com.example.CinemaCommandCenter.event.TicketBookedEvent;
import com.example.CinemaCommandCenter.exception.BookingException;
import com.example.CinemaCommandCenter.exception.ResourceNotFoundException;
import com.example.CinemaCommandCenter.model.Screening;
import com.example.CinemaCommandCenter.model.TicketBooking;
import com.example.CinemaCommandCenter.repository.ScreeningRepository;
import com.example.CinemaCommandCenter.repository.TicketBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TicketBookingService {

    private final TicketBookingRepository ticketBookingRepository;
    private final ApplicationEventPublisher publisher;
    private final ScreeningRepository screeningRepository;

    public TicketBooking bookTicket(TicketBooking ticketBooking) {
        Screening screening = screeningRepository.findById(ticketBooking.getScreeningId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Screening not found with id: " + ticketBooking.getScreeningId()));

        LocalDateTime screeningStartTime = screening.getStartTime();
        LocalDateTime now = LocalDateTime.now();

        // Validate screening time
        if (screeningStartTime.isBefore(now)) {
            throw new BookingException("Cannot book tickets for past screenings");
        }

        if (Duration.between(now, screeningStartTime).toHours() < 2) {
            throw new BookingException("Booking is not allowed. The screening starts in less than 2 hours.");
        }

        // Validate seat availability
        if (screening.getAvailableSeats() < ticketBooking.getSeatCount()) {
            throw new BookingException("Not enough seats available for booking");
        }

        ticketBooking.setBookingTime(now);
        ticketBookingRepository.save(ticketBooking);

        publisher.publishEvent(new TicketBookedEvent(
                this,
                ticketBooking.getScreeningId(),
                ticketBooking.getSeatCount(),
                ticketBooking.getViewerName()));
        return ticketBooking;
    }
}
