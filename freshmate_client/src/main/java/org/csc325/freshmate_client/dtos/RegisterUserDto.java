package org.csc325.freshmate_client.dtos;

/**
 * Data Transfer Object (DTO) for user registration information.
 * This class is used to transfer registration data between the client and the server.
 */
public class RegisterUserDto {
    private String email;
    private String password;
    private String fullName;

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
     * @return the current instance of RegisterUserDto.
     */
    public RegisterUserDto setEmail(String email) {
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
     * @return the current instance of RegisterUserDto.
     */
    public RegisterUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Gets the full name of the user.
     * 
     * @return the full name of the user.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the user.
     * 
     * @param fullName the full name to set.
     * @return the current instance of RegisterUserDto.
     */
    public RegisterUserDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}