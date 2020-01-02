package io.obelus.model;

import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * An {@link EventRepository} implementation that utilizes a {@link ConcurrentLinkedQueue} to store a collection of
 * {@link ObelusEvent} instances.
 * <p></p>
 */
public final class ConcurrentEventQueue implements EventRepository {

    private volatile ConcurrentLinkedQueue<ObelusEvent> events;

    public ConcurrentEventQueue() {
        this.events = new ConcurrentLinkedQueue<>();
    }

    /**
     * Adds an event to the queue
     *
     * @param eventName
     */
    @Override
    public synchronized void logEvent(String eventName) {
        events.add(new ObelusEvent(eventName));
    }

    /**
     * @param eventName
     * @param eventParams
     */
    @Override
    public synchronized void logEvent(String eventName, Map<String, Object> eventParams) {
        events.add(new ObelusEvent(eventName, eventParams));
    }

    /**
     * @return the {@code amount} of ObelusEvent from insertion order.
     */
    protected ConcurrentLinkedQueue<ObelusEvent> get() {
        return events;
    }
}
