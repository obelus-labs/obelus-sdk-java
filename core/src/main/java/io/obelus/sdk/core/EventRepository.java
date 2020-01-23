package io.obelus.sdk.core;

import java.util.Map;

public interface EventRepository {
    /**
     * Adds an event to the queue
     *
     * @param eventName
     *         the event name
     */
    void logEvent(String eventName);

    /**
     * @param eventName
     *         the event name, in lowercase replacing empty space with underscores
     * @param eventParams
     *         the event data, stored in the following structured:<ul><li> event_parameter_name : value</li></ul>
     */
    void logEvent(String eventName, Map<String, Object> eventParams);
}
