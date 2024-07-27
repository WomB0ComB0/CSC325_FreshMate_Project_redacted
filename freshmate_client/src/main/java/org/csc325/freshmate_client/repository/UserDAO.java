package org.csc325.freshmate_client.repository;

import org.csc325.freshmate_client.model.User;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) for user-related operations. This class provides
 * methods to interact with the user repository for login, registration, and
 * retrieving all users.
 */
public class UserDAO {
    private static UserDAO instance;
    private final UserRepository userRepository;

    /**
     * Constructs a new UserDAO with the specified UserRepository.
     * 
     * @param userRepository the UserRepository to be used by this DAO.
     */
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Returns the singleton instance of UserDAO. If the instance is null, it
     * initializes it with a new UserRepository.
     * 
     * @return the singleton instance of UserDAO.
     */
    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO(new UserRepository());
        }
        return instance;
    }

    /**
     * Logs in a user with the specified email and password.
     * 
     * @param email the email of the user.
     * @param password the password of the user.
     * @return true if the login is successful, false otherwise.
     */
    public boolean login(String email, String password) {
        return userRepository.login(email, password);
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
        return userRepository.register(fullName, email, password);
    }

    /**
     * Retrieves all users from the repository.
     * 
     * @return a list of all users.
     */
    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}