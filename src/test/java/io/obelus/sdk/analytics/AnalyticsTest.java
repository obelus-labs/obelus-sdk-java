package io.obelus.sdk.analytics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnalyticsTest {

    private Analytics analytics;

    @BeforeEach
    void setUp() {
        analytics = new Analytics();
    }

    @AfterEach
    void cleanUp() {
        analytics.clear();
    }

    @Test
    void logEventWithNoParameters() {
        Analytics analytics = new Analytics();
        analytics.logEvent("");
        assertFalse(analytics.isEmpty());
    }

    @Test
    void logEventWithSingleParameter() {
        Analytics analytics = new Analytics();
        int achievementId = 10;

        analytics.logEvent("achievement_unlocked", achievementId);
        assertFalse(analytics.isEmpty());
    }

    @Test
    void logEventWithMultipleParameters() {
        Analytics analytics = new Analytics();
        String currencyType = "USD";
        String username = "average_joe";
        float amount = 10.05f;

        analytics.logEvent("deposit_currency", currencyType, username, amount);
        analytics.flush();
        assertFalse(analytics.isEmpty());
    }

    @Test
    void flushWithNoEvents() {
        Analytics analytics = new Analytics();
        String username = "average_joe";

        analytics.logEvent("log_in", username);
        analytics.flush();
        assertTrue(analytics.isEmpty());
    }

    @Test
    void flushWithSingleEvent() {
        Analytics analytics = new Analytics();

        analytics.logEvent("achievement_unlocked", null);
        analytics.flush();
        assertFalse(analytics.isEmpty());
    }

    @Test
    void flushWithMultipleEvents() {
        Analytics analytics = new Analytics();

        int achievementId = 1;
        int achievementStageCompleted = 1;

        analytics.logEvent("achievement_progress", achievementId, achievementStageCompleted);
        analytics.flushAll();
    }
}
