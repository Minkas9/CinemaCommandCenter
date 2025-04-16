package com.example.CinemaCommandCenter.repository;

import com.example.CinemaCommandCenter.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository <Screening, Long> {
}
