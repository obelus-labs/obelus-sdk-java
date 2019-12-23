package io.obelus.sdk.analytics.event;

public class DefaultEventDispatcher implements EventDispatcher {

    /**
     * Connects to the backend service.
     */
    @Override
    public void connect() {

    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public void disconnect() {

    }

    /**
     * Flushes a single event.
     *
     * @return The number of bytes being flushed.
     */
    @Override
    public int push() {
        return 0;
    }

    /**
     * Flushes all committed events.
     *
     * @return The number of bytes being flushed.
     */
    @Override
    public int pushAll() {
        return 0;
    }
}
