package io.obelus.sdk.analytics;

import io.obelus.sdk.analytics.event.DefaultEventRepository;
import io.obelus.sdk.analytics.event.EventType;
import io.obelus.sdk.analytics.event.EventRepository;
import io.obelus.sdk.analytics.event.DefaultEventDispatcher;
import io.obelus.sdk.analytics.event.EventDispatcher;

import java.util.Arrays;

public final class Analytics {

    private volatile EventRepository eventRepository;
    private EventDispatcher eventDispatcher;

    Analytics() {
        this.eventRepository = new DefaultEventRepository();
        this.eventDispatcher = new DefaultEventDispatcher();
    }

    public void logEvent(EventType event) {
        this.logEvent(event.name().toLowerCase(), (Object[]) null);
    }

    public void logEvent(String eventName, Object... eventParams) {
        this.eventRepository.logEvent(eventName, Arrays.asList(eventParams));
    }

    public boolean isEmpty() {
        //TODO
        return false;
    }

    public boolean isConnected(){
        return eventDispatcher.isConnected();
    }

    public void flush() {
        eventDispatcher.push();
    }

    public void flushAll() {
        eventDispatcher.pushAll();
    }

    public void clear() {
    }
}
