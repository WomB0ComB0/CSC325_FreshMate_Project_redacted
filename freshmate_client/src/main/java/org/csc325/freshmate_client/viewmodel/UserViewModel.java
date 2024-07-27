package org.csc325.freshmate_client.viewmodel;

import org.csc325.freshmate_client.model.User;
import org.csc325.freshmate_client.repository.UserDAO;

/**
 * ViewModel class for managing user data and interactions.
 * This class provides methods for user login, registration, and accessing user data.
 */
public class UserViewModel {
    private User user;
    private UserDAO userDAO;

    /**
     * Constructs a new UserViewModel and initializes the UserDAO instance.
     */
    public UserViewModel() {
        userDAO = UserDAO.getInstance();
    }

    /**
     * Gets the current user.
     * 
     * @return the current user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the current user.
     * 
     * @param user the user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Logs in a user with the specified email and password.
     * 
     * @param email the email of the user.
     * @param password the password of the user.
     * @return true if the login is successful, false otherwise.
     */
    public boolean login(String email, String password) {
        return userDAO.login(email, password);
    }

    /**
     * Registers a new user with the specified details.
     * 
     * @param fullName the full name of the user.
     * @param email the email of the user.
     * @param password the password of the user.
     * @return true if the registration is successful, false otherwise.
     */
    public boolean register(String fullName, String email, String password) {
        return userDAO.register(fullName, email, password);
    }
}