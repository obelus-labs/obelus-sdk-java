package io.obelus.sdk.analytics.event;

public interface EventRepository {
    /**
     * Adds an event to the queue
     *
     * @param eventName
     */
    void logEvent(String eventName);

    /**
     * @param eventName
     * @param eventParams
     */
    void logEvent(String eventName, Object... eventParams);
}
