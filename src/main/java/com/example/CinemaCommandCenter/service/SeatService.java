package com.example.CinemaCommandCenter.service;

import com.example.CinemaCommandCenter.event.TicketBookedEvent;
import com.example.CinemaCommandCenter.model.Screening;
import com.example.CinemaCommandCenter.repository.ScreeningRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SeatService {

    private final ScreeningRepository screeningRepository;
    private final CacheManager cacheManager;
    private static final String CACHE_NAME = "screenings";

    @EventListener
    public void reduceSeatsWhenBooked(TicketBookedEvent event) {
        Long screeningId = event.getScreeningId();

        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new RuntimeException("Screening not found!"));

        if (screening.getAvailableSeats() < event.getSeatCount()) {
            throw new RuntimeException("Not enough seats available!");
        }

        screening.setAvailableSeats(screening.getAvailableSeats() - event.getSeatCount());
        screeningRepository.save(screening);

        log.info("There is only {} available seats for movie '{}'!!!",
                screening.getAvailableSeats(),
                screening.getMovieTitle()
        );

        Cache cache = cacheManager.getCache(CACHE_NAME);
        if (cache != null) {
            cache.evict(screeningId);
            log.info("Evicted screening ID {} from cache due to seat update", screeningId);
        } else {
            log.warn("Could not evict cache: Cache '{}' not found", CACHE_NAME);
        }
    }
}
