package com.lamuelainc.brknews.jpa.entities;

public enum EventStatus {
    /**
     * The event has started and accepts breaking news and comments
      */
    STARTED,

    /**
     * The event has ended and does not accept contributions
      */
    ENDED
}
