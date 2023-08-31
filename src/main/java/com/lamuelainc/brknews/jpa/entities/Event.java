package com.lamuelainc.brknews.jpa.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String eventTitle;
    private EventStatus status;

    // Hibernate reflection constructor
    private Event() {}

    public Event(String eventTitle) {
        this.eventTitle = eventTitle;
        this.status = EventStatus.STARTED;
    }

    public void end() {
        this.status = EventStatus.ENDED;
    }

    public Long getId() {
        return id;
    }

    public boolean isStarted() {
        return this.status == EventStatus.STARTED;
    }

    public String getEventTitle() {
        return eventTitle;
    }
}
