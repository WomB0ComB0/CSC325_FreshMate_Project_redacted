package org.csc325.freshmate_api.responses;

/**
 * Response class representing the login response containing a JWT token and its expiration time.
 */
public class LoginResponse {
    private String token;
    private long expiresIn;

    /**
     * Gets the JWT token.
     *
     * @return the JWT token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the JWT token.
     *
     * @param token the JWT token to set
     * @return the current instance of LoginResponse
     */
    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * Gets the expiration time of the JWT token in milliseconds.
     *
     * @return the expiration time in milliseconds
     */
    public long getExpiresIn() {
        return expiresIn;
    }

    /**
     * Sets the expiration time of the JWT token in milliseconds.
     *
     * @param expiresIn the expiration time to set
     * @return the current instance of LoginResponse
     */
    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    /**
     * Returns a string representation of the LoginResponse.
     *
     * @return a string representation of the LoginResponse
     */
    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}