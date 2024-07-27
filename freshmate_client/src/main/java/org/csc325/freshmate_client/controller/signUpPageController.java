package org.csc325.freshmate_client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import org.csc325.freshmate_client.dtos.RegisterUserDto;
import org.csc325.freshmate_client.viewmodel.AccessDataViewModel;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.google.firebase.auth.FirebaseAuth;
import com.google.cloud.firestore.Firestore;
import org.csc325.freshmate_client.model.FireStoreContext;
import org.csc325.freshmate_client.model.User;
import java.util.ArrayList;

/**
 * Controller class for the sign-up page. This class handles the interaction
 * between the user interface and the underlying data model for user registration.
 */
public class signUpPageController {
    @FXML private Button createActBtn1;
    @FXML private PasswordField PasswordTextField;
    @FXML private TextField FirstNameTextField,EmailTextField;
    private boolean key;
    @FXML private TextArea outputField;
    private FirebaseAuth firebaseAuth = FireStoreContext.getFirebaseAuth();
    private Firestore firestore = FireStoreContext.getFirestore();

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     */
    void initialize() {
        AccessDataViewModel accessDataViewModel = new AccessDataViewModel();
        FirstNameTextField.textProperty().bindBidirectional(accessDataViewModel.userNameProperty());
        EmailTextField.textProperty().bindBidirectional(accessDataViewModel.emailProperty());
        createActBtn1.disableProperty().bind(accessDataViewModel.isWritePossibleProperty().not());
    }

    /**
     * Handles the user registration action. This method is called when the user
     * interacts with the UI to create a new account.
     * 
     * @param event the ActionEvent triggered by the user interaction.
     */
    @FXML
    private void createUser(ActionEvent event) {
        String email = EmailTextField.getText();
        String password = PasswordTextField.getText();
        String displayName = FirstNameTextField.getText();

        RegisterUserDto registerUserDto = new RegisterUserDto()
                .setEmail(email)
                .setPassword(password)
                .setFullName(displayName);
        addRecordToFirestore(email, password, displayName);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/auth/signup";

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, registerUserDto, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("User registered successfully");
                logInPage(event);
            } else {
                System.out.println("Failed to register user: " + response.getBody());
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Adds a new user record to Firestore.
     * 
     * @param email     the email of the user.
     * @param password  the password of the user.
     * @param fullName  the full name of the user.
     */
    private void addRecordToFirestore(String email, String password, String fullName) {
        User user = new User(fullName, email, password, new ArrayList<String>(), "", "", null);
        firestore.collection("users").document(email).set(user);
    }

    /**
     * Navigates to the login page.
     * 
     * @param event the ActionEvent triggered by the user interaction.
     * @throws IOException if an I/O error occurs.
     */
    public void logInPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/csc325/freshmate_client/logInPage.fxml"));
        BorderPane root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}