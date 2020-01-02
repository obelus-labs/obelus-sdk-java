package io.obelus;

import io.obelus.model.EventRepository;
import io.obelus.model.ObelusClient;

import java.util.Map;

/**
 * An analytics event router.
 */
public final class ObelusAnalytics {
    /**
     * The singleton instance of runedocks.
     */
    private static ObelusAnalytics instance;

    private final EventRepository eventRepository;

    private ObelusAnalytics() {
        this.instance = instance;
        this.eventRepository = new ObelusClient();
    }

    /**
     * Retrieves an instance of {@link ObelusAnalytics}.
     */
    public static ObelusAnalytics analytics() {
        if (instance == null) {
            return new ObelusAnalytics();
        } else {
            return instance;
        }
    }

    /**
     * @param eventName
     * @param eventData
     */
    public void logEvent(String eventName, Map<String, Object> eventData) {
        this.eventRepository.logEvent(eventName, eventData);
    }
}