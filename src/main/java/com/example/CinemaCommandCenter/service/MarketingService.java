package com.example.CinemaCommandCenter.service;

import com.example.CinemaCommandCenter.event.TicketBookedEvent;
import com.example.CinemaCommandCenter.model.Screening;
import com.example.CinemaCommandCenter.model.TicketBooking;
import com.example.CinemaCommandCenter.repository.ScreeningRepository;
import com.example.CinemaCommandCenter.repository.TicketBookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarketingService {

    private final ScreeningRepository screeningRepository;

    @EventListener
    public void bookingInfoLogger(TicketBookedEvent event) {
        Long screeningId = event.getScreeningId();

        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new RuntimeException("Screening not found!"));

        log.info("Booking info: '{}' booked {} seat(s) for '{}' at {}!",
                event.getViewerName(),
                event.getSeatCount(),
                screening.getMovieTitle(),
                screening.getStartTime());
    }

}

