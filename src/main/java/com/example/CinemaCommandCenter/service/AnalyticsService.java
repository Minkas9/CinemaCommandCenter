package com.example.CinemaCommandCenter.service;

import com.example.CinemaCommandCenter.dto.ScreeningAnalyticsDTO;
import com.example.CinemaCommandCenter.exception.ResourceNotFoundException;
import com.example.CinemaCommandCenter.model.Screening;
import com.example.CinemaCommandCenter.repository.ScreeningRepository;
import com.example.CinemaCommandCenter.repository.TicketBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final TicketBookingRepository ticketBookingRepository;
    private final ScreeningRepository screeningRepository;

    public ScreeningAnalyticsDTO getScreeningAnalytics(Long screeningId) {
        int totalBookings = ticketBookingRepository.countByScreeningId(screeningId);

        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new ResourceNotFoundException("Screening not found with id: " + screeningId));

        int remainingSeats = screening.getAvailableSeats();

        return new ScreeningAnalyticsDTO(totalBookings, remainingSeats);
    }
}