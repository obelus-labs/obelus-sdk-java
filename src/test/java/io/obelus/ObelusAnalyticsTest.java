package io.obelus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ObelusAnalyticsTest {


    @Test
    void isSingleton() {
        ObelusAnalytics instance = ObelusAnalytics.analytics();
        Assertions.assertNotNull(instance);

        // Attempt to create another instance of Runedocks.
        ObelusAnalytics instance2 = ObelusAnalytics.analytics();
        Assertions.assertEquals(instance, instance2);
    }

    @Test
    void logEventWithNoParameters() {
        ObelusAnalytics analytics = ObelusAnalytics.analytics();
        analytics.logEvent("", null);
    }

    @Test
    void logEventWithSingleParameter() {
        ObelusAnalytics analytics = ObelusAnalytics.analytics();
        var eventData = new HashMap<String, Object>();

        eventData.put("achievement_name", "collect_10_legos");
        eventData.put("amount_collected", 9);

        analytics.logEvent("achievement_progress", eventData);
    }

    @Test
    void logEventWithMultipleParameters() {
        ObelusAnalytics analytics = ObelusAnalytics.analytics();

        var eventData = new HashMap<String, Object>();
        eventData.put("current_type", "USD");
        eventData.put("amount", 10.05f);

        analytics.logEvent("deposit_currency", eventData);
    }

    @Test
    void flushWithNoEvents() {
        ObelusAnalytics analytics = ObelusAnalytics.analytics();
        var eventData = new HashMap<String, Object>();
        eventData.put("username", "average_joe");

        analytics.logEvent("log_in", eventData);
    }

    @Test
    void flushWithSingleEvent() {
        ObelusAnalytics analytics = ObelusAnalytics.analytics();
        analytics.logEvent("achievement_unlocked", null);
    }

    @Test
    void flushWithMultipleEvents() {
        ObelusAnalytics analytics = ObelusAnalytics.analytics();

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
