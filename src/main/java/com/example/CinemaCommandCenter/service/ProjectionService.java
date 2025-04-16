package com.example.CinemaCommandCenter.service;

import com.example.CinemaCommandCenter.event.TicketBookedEvent;
import com.example.CinemaCommandCenter.model.Screening;
import com.example.CinemaCommandCenter.repository.ScreeningRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectionService {

    private final ScreeningRepository screeningRepository;

    @EventListener
    public void projectionNotifier(TicketBookedEvent event) {
        Long screeningId = event.getScreeningId();

        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new RuntimeException("Screening not found!"));

        log.info("Projection notifier: Movie '{}' starts at {}!",
                screening.getMovieTitle(),
                screening.getStartTime().toString()
        );
    }

}
