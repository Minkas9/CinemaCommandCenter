package com.example.CinemaCommandCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreeningAnalyticsDTO {

    private Integer totalBookings;
    private Integer remainingSeats;
}
