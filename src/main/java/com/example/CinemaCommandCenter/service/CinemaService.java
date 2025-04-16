package com.example.CinemaCommandCenter.service;


import com.example.CinemaCommandCenter.model.Cinema;
import com.example.CinemaCommandCenter.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }
}
