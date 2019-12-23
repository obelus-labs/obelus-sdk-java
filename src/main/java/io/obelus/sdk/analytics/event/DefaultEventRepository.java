package io.obelus.sdk.analytics.event;

import java.util.*;

public final class DefaultEventRepository implements EventRepository {

    private volatile HashMap<String, Object> events;

    public DefaultEventRepository() {
        this.events = new HashMap<>();
    }

    /**
     * Adds an event to the queue
     *
     * @param eventName
     */
    @Override
    public synchronized void logEvent(String eventName) {
        this.events.put(eventName, null);
    }

    /**
     * @param eventName
     * @param eventParams
     */
    @Override
    public synchronized void logEvent(String eventName, Object... eventParams) {
        this.events.put(eventName, Arrays.asList(eventParams));
    }
}
