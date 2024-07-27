package org.csc325.freshmate_client.responses;

/**
 * Represents the response received after a successful login.
 * This class contains the authentication token and its expiration time.
 */
public class LoginResponse {
    private String token;
    private long expiresIn;

    /**
     * Gets the authentication token.
     * 
     * @return the authentication token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the authentication token.
     * 
     * @param token the authentication token to set.
     * @return the current instance of LoginResponse.
     */
    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * Gets the expiration time of the token in seconds.
     * 
     * @return the expiration time of the token in seconds.
     */
    public long getExpiresIn() {
        return expiresIn;
    }

    /**
     * Sets the expiration time of the token in seconds.
     * 
     * @param expiresIn the expiration time to set.
     * @return the current instance of LoginResponse.
     */
    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}