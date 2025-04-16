package com.example.CinemaCommandCenter.service;

import com.example.CinemaCommandCenter.dto.ScreeningAnalyticsDTO;
import com.example.CinemaCommandCenter.model.TicketBooking;
import com.example.CinemaCommandCenter.repository.ScreeningRepository;
import com.example.CinemaCommandCenter.repository.TicketBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final TicketBookingRepository ticketBookingRepository;
    private ScreeningRepository screeningRepository;

    public ScreeningAnalyticsDTO getScreeningInfo(Long screeningId){

        List<TicketBooking> ticketBookings = ticketBookingRepository.findAll();

        List<TicketBooking> ticketBookingsByScreeningId = ticketBookings
                .stream()
                .filter(t->t.getScreeningId().equals(screeningId))
                .toList();

        Integer totalBookings = ticketBookingsByScreeningId.size();

        Integer remainingSeats = ticketBookingsByScreeningId
                .stream()
                .mapToInt(TicketBooking::getSeatCount) // assuming getSeatCount() returns int or Integer
                .sum();

        return new ScreeningAnalyticsDTO(totalBookings,remainingSeats);


    }
}