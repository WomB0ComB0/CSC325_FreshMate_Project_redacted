package org.csc325.freshmate_client.dtos;

/**
 * Data Transfer Object (DTO) for user login information.
 * This class is used to transfer login data between the client and the server.
 */
public class LoginUserDto {
    private String email;
    private String password;

    /**
     * Gets the email of the user.
     * 
     * @return the email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     * 
     * @param email the email to set.
     * @return the current instance of LoginUserDto.
     */
    public LoginUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Gets the password of the user.
     * 
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password the password to set.
     * @return the current instance of LoginUserDto.
     */
    public LoginUserDto setPassword(String password) {
        this.password = password;
        return this;
    }
}