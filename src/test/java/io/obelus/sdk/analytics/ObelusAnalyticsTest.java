package io.obelus.sdk.analytics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ObelusAnalyticsTest {

    @Test
    void hasSingleton() {
        ObelusAnalytics instance = ObelusAnalytics.analytics();
        Assertions.assertNotNull(instance);

        // Attempt to create another instance of Runedocks.
        ObelusAnalytics instance2 = ObelusAnalytics.analytics();
        Assertions.assertEquals(instance, instance2);
    }

    @Test
    void isImmutable() {

    }

    @Test
    void cannotInstantiate() {

    }
}