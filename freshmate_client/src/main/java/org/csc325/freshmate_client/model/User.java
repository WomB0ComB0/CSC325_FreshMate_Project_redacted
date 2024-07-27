package org.csc325.freshmate_client.model;

import java.util.ArrayList;

/**
 * Represents a user with details such as full name, email, password, links, bio, and UUID.
 */
public class User {
    private String fullName;
    private String email;
    private String password;
    private ArrayList<String> links;
    private String bio;
    private String uuid;

    /**
     * Constructs a new User with the specified details.
     * 
     * @param fullName the full name of the user.
     * @param email the email of the user.
     * @param password the password of the user.
     * @param links a list of links associated with the user.
     * @param bio the bio of the user.
     * @param uuid the UUID of the user.
     * @param id the ID of the user.
     */
    public User(String fullName, String email, String password, ArrayList<String> links, String bio, String uuid,
            Long id) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.links = links;
        this.bio = bio;
        this.uuid = uuid;
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
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

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
     */
    public void setEmail(String email) {
        this.email = email;
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
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the list of links associated with the user.
     * 
     * @return the list of links.
     */
    public ArrayList<String> getLinks() {
        return links;
    }

    /**
     * Sets the list of links associated with the user.
     * 
     * @param links the list of links to set.
     */
    public void setLinks(ArrayList<String> links) {
        this.links = links;
    }

    /**
     * Gets the bio of the user.
     * 
     * @return the bio of the user.
     */
    public String getBio() {
        return bio;
    }

    /**
     * Sets the bio of the user.
     * 
     * @param bio the bio to set.
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Gets the UUID of the user.
     * 
     * @return the UUID of the user.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the UUID of the user.
     * 
     * @param uuid the UUID to set.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Returns a string representation of the user.
     * 
     * @return a string representation of the user.
     */
    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", links=" + links +
                ", bio='" + bio + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}