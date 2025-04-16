package com.example.CinemaCommandCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoyaltyPointsDTO {
    private String viewerName;
    private Integer points;

    public static LoyaltyPointsDTO create(String viewerName, Integer points) {
        return new LoyaltyPointsDTO(viewerName, points);
    }
}