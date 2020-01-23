package io.obelus.sdk.core;

import io.obelus.sdk.core.converter.GsonMarshaller;

import java.util.Map;

/**
 * An analytics event router.
 */
public final class ObelusAnalytics {
    /**
     * The singleton instance of runedocks.
     */
    private static ObelusAnalytics INSTANCE;

    private final ObelusEventDispatcher eventDispatcher;

    private final ConcurrentEventQueue eventQueue;

    private final ConcurrentEventQueueProcessor eventProcessor;

    /**
     * Private constructor, encourages usage of singleton.
     */
    private ObelusAnalytics() {
        this.INSTANCE = this;
        this.eventDispatcher = new ObelusEventDispatcher();
        this.eventQueue = new ConcurrentEventQueue();
        this.eventProcessor = new ConcurrentEventQueueProcessor(new GsonMarshaller());
    }

    /**
     * Retrieves the single instance of {@link ObelusAnalytics}.
     */
    public static ObelusAnalytics analytics() {
        if (INSTANCE == null) {
            return new ObelusAnalytics();
        } else {
            return INSTANCE;
        }
    }

    /**
     * Queues an event to be logged.
     *
     * @param eventName
     * @param eventData
     */
    public void logEvent(String eventName, Map<String, Object> eventData) {
        this.eventQueue.logEvent(eventName, eventData);
    }
}