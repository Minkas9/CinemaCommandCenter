package com.example.CinemaCommandCenter.service;

import com.example.CinemaCommandCenter.model.Cinema;
import com.example.CinemaCommandCenter.model.Screening;
import com.example.CinemaCommandCenter.repository.CinemaRepository;
import com.example.CinemaCommandCenter.repository.ScreeningRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final CinemaRepository cinemaRepository;
    private final CacheManager cacheManager;
    private static final String CACHE_NAME = "screenings";

    public Screening getScreeningById(Long id) {
        Cache screeningCache = cacheManager.getCache(CACHE_NAME);

        if (screeningCache != null) {
            Screening screeningFromCache = screeningCache.get(id, Screening.class);
            if (screeningFromCache != null) {
                log.info("Retrieved screening from cache {}", screeningFromCache);
                return screeningFromCache;
            }
        }
        log.info("Retrieving Screening from database.............");
        Screening screeningFromDB = screeningRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Screening not found with id: " + id));

        if (screeningFromDB != null && screeningCache != null) {
            screeningCache.put(id, screeningFromDB);
            log.info("Putting Screening to cash : {}", screeningFromDB);
        }
        return screeningFromDB;
    }

    public Screening addScreening(Screening screening, Long cinemaId) {
        Cinema cinema = cinemaRepository.findById(cinemaId).orElseThrow(RuntimeException::new);
        Screening savedScreening = screeningRepository.save(screening);
        cinema.getScreenings().add(savedScreening);
        cinemaRepository.save(cinema);

        Cache screeningCache = cacheManager.getCache(CACHE_NAME);
        if (screeningCache != null && savedScreening.getId() != null) {
            screeningCache.put(savedScreening.getId(), savedScreening);
            log.info("Cached new screening: {}", savedScreening);
        } else {
            log.warn("Could not cache screening. Cache or ID was null.");
        }

        return savedScreening;
    }
}




