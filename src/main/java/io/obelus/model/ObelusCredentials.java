package io.obelus.model;

/**
 * <p> This object is used to store Oauth2 results. </p>
 * {@link EventRepository} uses this to construct requests.
 */
public class ObelusCredentials {

    private final String projectKey;

    private final String accessToken;

    /**
     * Create an Obelus credentials object, used to authorized your projects.
     *
     * @param projectKey
     *         Your custom project key, specific to all projects that you own.
     * @param accessToken
     *         Your access token, specific to this project.
     */
    public ObelusCredentials(String projectKey, String accessToken) {
        if (projectKey == null) {
            throw new IllegalArgumentException("No project_key provided.");
        }

        if (accessToken == null) {
            throw new IllegalArgumentException("No access_token provided.");
        }

        this.projectKey = projectKey;
        this.accessToken = accessToken;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

}