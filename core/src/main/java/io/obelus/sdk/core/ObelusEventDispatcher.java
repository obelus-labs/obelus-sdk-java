package io.obelus.sdk.core;

import okhttp3.*;

import java.io.IOException;

/**
 * Dispatches {@link ObelusEvent} instances via HTTP.
 */
public class ObelusEventDispatcher {

    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private static final String URL = "https://localhost:8080";

    private final OkHttpClient client = new OkHttpClient();

    String post(String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(URL)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
