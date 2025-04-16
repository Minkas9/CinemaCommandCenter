package com.example.CinemaCommandCenter.service;

import com.example.CinemaCommandCenter.event.TicketBookedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoyaltyService {

        private final Map<String, Integer> loyaltyPoints = new HashMap<>();

        @EventListener
        public void handleTicketBooked(TicketBookedEvent event) {
            String viewerName = event.getViewerName();
            int newPoints = event.getSeatCount();

            loyaltyPoints.put(
                    viewerName,
                    //Give me the current value if it exists, or default to 0 if it doesn't.
                    loyaltyPoints.getOrDefault(viewerName, 0) + newPoints
            );

            log.info("Loyalty: {} now has {} loyalty point(s)",
                    viewerName, loyaltyPoints.get(viewerName));
        }
    }

