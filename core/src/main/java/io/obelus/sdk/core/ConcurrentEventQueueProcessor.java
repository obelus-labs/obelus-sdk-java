package io.obelus.sdk.core;

import io.obelus.sdk.core.converter.JsonMarshaller;

/**
 * This class is used to transform an entire {@link ConcurrentEventQueue} into a single JSON object.
 *
 * <p>{@link io.obelus.sdk.core.ObelusAnalytics} uses this object to compress queued events that will eventually be
 * sent to the Obelus servers.</p>
 */

public class ConcurrentEventQueueProcessor {

    private JsonMarshaller jsonMarshaller;

    /**
     * Creates a new concurrent event queue processor.
     *
     * @param jsonMarshaller
     *         the {@link io.obelus.sdk.core.converter.JsonMarshaller} implementation to use.
     */
    public ConcurrentEventQueueProcessor(JsonMarshaller jsonMarshaller) {
        this.jsonMarshaller = jsonMarshaller;
    }

    /**
     * Converts a {@link ConcurrentEventQueue} into a single JSON object.
     */
    protected synchronized String process(ConcurrentEventQueue repository) {
        if (repository.get().isEmpty()) {
            return null;
        }

        return jsonMarshaller.toJson(repository);
    }
}
