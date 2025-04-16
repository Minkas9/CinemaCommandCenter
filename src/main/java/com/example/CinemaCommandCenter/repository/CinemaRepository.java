package com.example.CinemaCommandCenter.repository;

import com.example.CinemaCommandCenter.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CinemaRepository extends JpaRepository <Cinema, Long> {
}
