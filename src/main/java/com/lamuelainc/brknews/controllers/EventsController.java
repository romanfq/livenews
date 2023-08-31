package com.lamuelainc.brknews.controllers;

import com.lamuelainc.brknews.models.EventDefinition;
import com.lamuelainc.brknews.models.EventId;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

    @PostMapping(path = "/events/start",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public EventId startEvent(@RequestBody EventDefinition eventDefinition) {
        System.out.println(eventDefinition);
        return new EventId(System.currentTimeMillis());
    }
}
