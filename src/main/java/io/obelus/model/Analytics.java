package io.obelus.model;

import java.util.Map;

public final class Analytics {

    private volatile EventRepository eventRepository;

    Analytics() {
        this.eventRepository = new ObelusClient();
    }

    /**
     * @param eventName
     * @param eventData
     */
    public void logEvent(String eventName, Map<String, Object> eventData) {
        this.eventRepository.logEvent(eventName, eventData);
    }
}
