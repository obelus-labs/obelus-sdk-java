package io.obelus.sdk.analytics.event;

/**
 * An event dispatcher is responsible for pushing (or sending) events to the Datamob servers.
 */
public interface EventDispatcher {

    /**
     * Connects to the backend service.
     */
    void connect();

    boolean isConnected();

    /**
     * Closes the connection, and empties
     */
    void disconnect();

    /**
     * Pushes a single event over the wire.
     *
     * @return The number of bytes being flushed.
     */
    int push();

    /**
     * Pushes all committed events.
     *
     * @return The number of bytes being flushed.
     */
    int pushAll();
}
