package com.example.CinemaCommandCenter.repository;

import com.example.CinemaCommandCenter.model.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long> {
}
