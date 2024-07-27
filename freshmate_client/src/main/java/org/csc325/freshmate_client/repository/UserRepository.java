package org.csc325.freshmate_client.repository;

import org.csc325.freshmate_client.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for managing user data. This class provides methods to
 * perform CRUD operations on user data.
 */
public class UserRepository {
    private List<User> users = new ArrayList<>();

    /**
     * Constructs a new UserRepository.
     */
    public UserRepository() {}

    /**
     * Finds a user by their email.
     * 
     * @param email the email of the user to find.
     * @return an Optional containing the found user, or an empty Optional if no user is found.
     */
    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    /**
     * Saves a new user to the repository.
     * 
     * @param user the user to save.
     * @return the saved user.
     */
    public User save(User user) {
        users.add(user);
        return user;
    }

    /**
     * Logs in a user with the specified email and password.
     * 
     * @param email the email of the user.
     * @param password the password of the user.
     * @return true if the login is successful, false otherwise.
     */
    public boolean login(String email, String password) {
        return findByEmail(email).map(user -> user.getPassword().equals(password)).orElse(false);
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
        if (findByEmail(email).isPresent()) {
            return false;
        }
        users.add(new User(fullName, email, password, new ArrayList<>(), "", "", null));
        return true;
    }

    /**
     * Retrieves all users from the repository.
     * 
     * @return a list of all users.
     */
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    /**
     * Deletes a user from the repository.
     * 
     * @param user the user to delete.
     */
    public void delete(User user) {
        users.remove(user);
    }

    /**
     * Updates an existing user in the repository.
     * 
     * @param user the user to update.
     * @return the updated user.
     */
    public User update(User user) {
        int index = users.indexOf(user);
        if (index != -1) {
            users.set(index, user);
        }
        return user;
    }

    /**
     * Deletes a user by their email.
     * 
     * @param email the email of the user to delete.
     */
    public void deleteByEmail(String email) {
        users.removeIf(user -> user.getEmail().equals(email));
    }

    /**
     * Deletes all users from the repository.
     */
    public void deleteAll() {
        users.clear();
    }

    /**
     * Deletes all specified users from the repository.
     * 
     * @param users the list of users to delete.
     */
    public void deleteAll(List<User> users) {
        users.clear();
    }
}