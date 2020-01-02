package io.obelus.model.converter;


/**
 * Converts an {@link Object} instance to and from Json.
 */
public interface JsonMarshaller {

    /**
     * @param object
     *         The event to convert.
     */
    String toJson(Object object);
}
