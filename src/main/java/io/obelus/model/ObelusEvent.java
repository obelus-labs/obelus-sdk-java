package io.obelus.model;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.Map;

/**
 * A single event to be sent to the Obelus platform.
 */
final class ObelusEvent {

    @SerializedName("event_name")
    private final String eventName;

    @SerializedName("event_properties")
    private final Map<String, Object> eventData;

    /**
     * Creates an event with NO event properties.
     *
     * @param eventName
     *         The event name in {@code snake_case}.
     */
    public ObelusEvent(String eventName) {
        this(eventName, Collections.emptyMap());
    }

    /**
     * @param eventName
     *         The event name in {@code snake_case}.
     * @param eventData
     *         The event properties. Each property name should also be in {@code snake_case}.
     */
    public ObelusEvent(String eventName, Map<String, Object> eventData) {
        this.eventName = eventName;
        this.eventData = eventData;
    }

    public String getEventName() {
        return eventName;
    }

    public Map<String, Object> getEventData() {
        return eventData;
    }
}
