package org.csc325.freshmate_client.controller;

import javafx.fxml.FXML;
import java.io.IOException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.csc325.freshmate_client.dtos.LoginUserDto;
import org.csc325.freshmate_client.responses.LoginResponse;
import javafx.scene.control.TextField;

/**
 * Controller class for the login page. This class handles the interaction
 * between the user interface and the underlying data model for user login.
 */
public class logInPageController {
    private final RestTemplate restTemplate = new RestTemplate();

    @FXML
    private TextField emailTextField;
    
    @FXML
    private TextField passwordTextField;

    /**
     * Handles the user login action. This method is called when the user
     * interacts with the UI to log in.
     * 
     * @param event the ActionEvent triggered by the user interaction.
     * @throws IOException if an I/O error occurs.
     */
    public void logInUser(ActionEvent event) throws IOException {
        String email = emailTextField.getText();
        String password = passwordTextField.getText();

        LoginUserDto loginUserDto = new LoginUserDto()
                .setEmail(email)
                .setPassword(password);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity<LoginUserDto> request = new HttpEntity<>(loginUserDto, headers);

            ResponseEntity<LoginResponse> response = restTemplate.postForEntity(
                "http://localhost:8080/auth/login", 
                request, 
                LoginResponse.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Login successful!");
                String token = response.getBody().getToken();
                
                navigateToHome(event);
            } else {
                System.out.println("Failed to login: " + response.getBody());
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Navigates to the sign-up page. This method is called when the user
     * interacts with the UI to navigate to the sign-up page.
     * 
     * @param event the ActionEvent triggered by the user interaction.
     * @throws IOException if an I/O error occurs.
     */
    public void signUpPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/csc325/freshmate_client/signUpPage.fxml"));
        BorderPane root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    /**
     * Navigates to the home page. This method is called after a successful login.
     * 
     * @param event the ActionEvent triggered by the user interaction.
     * @throws IOException if an I/O error occurs.
     */
    private void navigateToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/csc325/freshmate_client/homePage.fxml"));
        BorderPane root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}