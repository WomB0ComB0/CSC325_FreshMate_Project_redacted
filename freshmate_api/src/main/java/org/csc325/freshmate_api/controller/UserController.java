package org.csc325.freshmate_api.controller;

import org.csc325.freshmate_api.entities.User;
import org.csc325.freshmate_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for handling user-related requests.
 */
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    /**
     * Constructor for UserController.
     *
     * @param userService the UserService to be used for user-related operations
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to retrieve the authenticated user's details.
     *
     * @return a ResponseEntity containing the authenticated User
     */
    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    /**
     * Endpoint to retrieve all users.
     *
     * @return a ResponseEntity containing a list of all Users
     */
    @GetMapping
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }
}