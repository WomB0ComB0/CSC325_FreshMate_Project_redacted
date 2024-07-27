package org.csc325.freshmate_api.service;

import org.csc325.freshmate_api.dtos.LoginUserDto;
import org.csc325.freshmate_api.dtos.RegisterUserDto;
import org.csc325.freshmate_api.entities.User;
import org.csc325.freshmate_api.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling authentication-related operations.
 */
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * Constructor for AuthenticationService.
     *
     * @param userRepository the UserRepository to be used for user-related operations
     * @param authenticationManager the AuthenticationManager to be used for authentication
     * @param passwordEncoder the PasswordEncoder to be used for encoding passwords
     */
    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a new user.
     *
     * @param input the data transfer object containing user registration details
     * @return the registered User
     */
    public User signup(RegisterUserDto input) {
        var user = new User()
            .setFullName(input.getFullName())
            .setEmail(input.getEmail())
            .setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    /**
     * Authenticates a user.
     *
     * @param input the data transfer object containing user login details
     * @return the authenticated User
     */
    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getEmail(),
                input.getPassword()
            )
        );

        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }

    /**
     * Retrieves all users.
     *
     * @return a list of all Users
     */
    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}