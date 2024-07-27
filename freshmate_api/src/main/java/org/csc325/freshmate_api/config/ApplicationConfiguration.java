package org.csc325.freshmate_api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.csc325.freshmate_api.repository.UserRepository;
import org.csc325.freshmate_api.util.JsonUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Configuration class for application-wide beans and settings.
 */
@Configuration
public class ApplicationConfiguration {
    private final UserRepository userRepository;

    /**
     * Constructor for ApplicationConfiguration.
     *
     * @param userRepository the UserRepository to be used for user-related
     *                       operations
     */
    public ApplicationConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Bean definition for UserDetailsService.
     *
     * @return a UserDetailsService that loads user details from the UserRepository
     */
    @Bean
    UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    /**
     * Bean definition for BCryptPasswordEncoder.
     *
     * @return a BCryptPasswordEncoder for encoding passwords
     */
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean definition for AuthenticationManager.
     *
     * @param config the AuthenticationConfiguration to be used for authentication
     * @return an AuthenticationManager for managing authentication
     * @throws Exception if an error occurs while creating the AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * Bean definition for AuthenticationProvider.
     *
     * @return an AuthenticationProvider for providing authentication
     */
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    /**
     * Bean definition for ObjectMapper.
     *
     * @return an ObjectMapper configured with custom settings
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return JsonUtils.MAPPER;
    }
}