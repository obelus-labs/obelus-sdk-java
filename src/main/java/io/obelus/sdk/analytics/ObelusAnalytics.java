package io.obelus.sdk.analytics;

/**
 * An analytics event router.
 */
public final class ObelusAnalytics {
    /**
     * The singleton instance of runedocks.
     */
    private static ObelusAnalytics instance;

    private ObelusAnalytics() {
        this.instance = instance;
    }

    /**
     * Retrieves an instance of {@link ObelusAnalytics}.
     */
    public static ObelusAnalytics analytics() {
        if (instance == null) {
            return new ObelusAnalytics();
        } else {
            return instance;
        }
    }
}