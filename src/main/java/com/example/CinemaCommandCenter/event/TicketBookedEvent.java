package com.example.CinemaCommandCenter.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class TicketBookedEvent extends ApplicationEvent {

    private final Long screeningId;
    private final Integer seatCount;
    private final String viewerName;

    public TicketBookedEvent(Object source, Long screeningId, Integer seatCount, String viewerName) {
        super(source);
        this.screeningId = screeningId;
        this.seatCount = seatCount;
        this.viewerName = viewerName;
    }
}
