package io.obelus.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class AnalyticsTest {

    @Test
    void logEventWithNoParameters() {
        Analytics analytics = new Analytics();
        analytics.logEvent("", null);
    }

    @Test
    void logEventWithSingleParameter() {
        Analytics analytics = new Analytics();
        var eventData = new HashMap<String, Object>();

        eventData.put("achievement_name", "collect_10_legos");
        eventData.put("amount_collected", 9);

        analytics.logEvent("achievement_progress", eventData);
    }

    @Test
    void logEventWithMultipleParameters() {
        Analytics analytics = new Analytics();

        var eventData = new HashMap<String, Object>();
        eventData.put("current_type", "USD");
        eventData.put("amount", 10.05f);

        analytics.logEvent("deposit_currency", eventData);
    }

    @Test
    void flushWithNoEvents() {
        Analytics analytics = new Analytics();
        var eventData = new HashMap<String, Object>();
        eventData.put("username", "average_joe");

        analytics.logEvent("log_in", eventData);
    }

    @Test
    void flushWithSingleEvent() {
        Analytics analytics = new Analytics();
        analytics.logEvent("achievement_unlocked", null);
    }

    @Test
    void flushWithMultipleEvents() {
        Analytics analytics = new Analytics();

        // Event 1
        var event1Data = new HashMap<String, Object>();
        event1Data.put("quest_name", "the_mountaineer");
        event1Data.put("quest_stage_completed", 4);
        analytics.logEvent("quest_progress", event1Data);

        // Event 2
        var event2Data = new HashMap<String, Object>();
        event2Data.put("quest_name", "the_mountaineer");
        analytics.logEvent("quest_completed", event2Data);
    }
}
