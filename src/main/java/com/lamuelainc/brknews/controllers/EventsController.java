package com.lamuelainc.brknews.controllers;

import com.lamuelainc.brknews.jpa.EventsRepository;
import com.lamuelainc.brknews.jpa.entities.Event;
import com.lamuelainc.brknews.models.EventDefinition;
import com.lamuelainc.brknews.models.EventId;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class EventsController {
    private final EventsRepository repository;

    public EventsController(EventsRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/events")
    public Iterable<Event> list() {
        return this.repository.findAll();
    }

    @GetMapping(path = "/events/{id}")
    public Event listById(@PathVariable("id") Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> eventNotFound(id));
    }

    @PostMapping(path = "/events/start",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public EventId startEvent(@RequestBody EventDefinition eventDefinition) {
        Event saved = this.repository.save(new Event(eventDefinition.eventTitle()));
        return new EventId(saved.getId());
    }

    @PutMapping(path = "/events/end",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public void endEvent(@RequestBody EventId eventId)  {
        Optional<Event> maybeEvent = this.repository.findById(eventId.eventId());
        if (maybeEvent.isEmpty() || !maybeEvent.get().isStarted()) {
           throw eventNotFound(eventId.eventId());
        }
        Event event = maybeEvent.get();
        event.end();
        this.repository.save(event);
    }

    private static ResponseStatusException eventNotFound(long eventId) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Event %s doesn't exist or has not been started", eventId));
    }
}
