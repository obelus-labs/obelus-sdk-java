package io.obelus.model.converter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * An {@link JsonMarshaller} instance that uses Gson.
 *
 * @see com.google.gson.Gson
 */
public class GsonMarshaller implements JsonMarshaller {

    private static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    @Override
    public String toJson(Object object) {
        return gson.toJson(object);
    }

}
