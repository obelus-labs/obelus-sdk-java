package io.obelus.sdk.core;

import io.obelus.sdk.core.converter.GsonMarshaller;
import io.obelus.sdk.core.converter.JsonMarshaller;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrentEventQueueProcessorTest {

    private JsonMarshaller marshaller = new GsonMarshaller();

    @Test
    void whenHasNoEvents_returnEmptyString() {
        ConcurrentEventQueueProcessor processor = new ConcurrentEventQueueProcessor(marshaller);
        ConcurrentEventQueue queue = new ConcurrentEventQueue();

        String asJson = processor.process(queue);
        assertNull(asJson);
    }

    @Test
    void whenHasSingleEvents_returnJson() {
        ConcurrentEventQueueProcessor processor = new ConcurrentEventQueueProcessor(marshaller);
        ConcurrentEventQueue queue = new ConcurrentEventQueue();
        queue.logEvent("test_event_name");
        String asJson = processor.process(queue);

        System.out.println(asJson);
        assertNotNull(asJson);
    }

    @Test
    void whenHasMultipleEvents_returnStructuredJson() {
        ConcurrentEventQueueProcessor processor = new ConcurrentEventQueueProcessor(marshaller);
        ConcurrentEventQueue queue = new ConcurrentEventQueue();

        // event 1
        var event1data = new HashMap<String, Object>();
        event1data.put("event_1_property_1", 100);
        event1data.put("event_1_property_2", "test_string");
        queue.logEvent("test_event_name1", event1data);

        // event 2
        var event2data = new HashMap<String, Object>();
        event2data.put("event_2_property_1", 'a');
        event2data.put("event_2_property_2", 100f);
        queue.logEvent("test_event_name2", event2data);

        // process events
        String asJson = processor.process(queue);
        System.out.println(asJson);
    }
}