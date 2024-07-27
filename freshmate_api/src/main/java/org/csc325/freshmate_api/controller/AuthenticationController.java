package org.csc325.freshmate_api.controller;

import org.csc325.freshmate_api.entities.User;
import org.csc325.freshmate_api.dtos.LoginUserDto;
import org.csc325.freshmate_api.dtos.RegisterUserDto;
import org.csc325.freshmate_api.responses.LoginResponse;
import org.csc325.freshmate_api.service.AuthenticationService;
import org.csc325.freshmate_api.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling authentication-related requests.
 */
@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    /**
     * Constructor for AuthenticationController.
     *
     * @param jwtService the JwtService to be used for JWT operations
     * @param authenticationService the AuthenticationService to be used for authentication operations
     */
    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    /**
     * Endpoint for user registration.
     *
     * @param registerUserDto the data transfer object containing user registration details
     * @return a ResponseEntity containing the registered User
     */
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    /**
     * Endpoint for user login.
     *
     * @param loginUserDto the data transfer object containing user login details
     * @return a ResponseEntity containing the LoginResponse with the JWT token and expiration time
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}