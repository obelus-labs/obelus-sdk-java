package io.obelus.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObelusCredentialsTest {

    private final String testProjectKey = "TEST_KEY";
    private final String testAccessToken = "TEST_TOKEN";

    @Test
    void whenContainsProjectKeyAndAccessToken_pass() {
        assertDoesNotThrow(() -> {
            var credentials = new ObelusCredentials(testProjectKey, testAccessToken);
        });
    }

    @Test
    void whenDoesNotContainProjectKey_throwException() {
        assertThrows(IllegalArgumentException.class, () -> {
            var credentials = new ObelusCredentials(null, testAccessToken);
        });
    }

    @Test
    void whenDoesNotContainAccessToken_throwException() {
        assertThrows(IllegalArgumentException.class, () -> {
            var credentials = new ObelusCredentials(testProjectKey, null);
        });
    }
}