package com.lamuelainc.brknews.jpa;

import com.lamuelainc.brknews.jpa.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventsRepository extends CrudRepository<Event, Long> {
}
