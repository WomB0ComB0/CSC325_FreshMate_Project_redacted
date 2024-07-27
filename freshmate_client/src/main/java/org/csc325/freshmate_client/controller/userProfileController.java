package org.csc325.freshmate_client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the user profile page. This class handles the interaction
 * between the user interface and the underlying data model for the user profile.
 */
public class userProfileController implements Initializable {

    @FXML
    private Hyperlink changeProfilePic;

    @FXML
    private Label emailAddressLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private ImageView userProfilePic;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label usersNameLabel;

    private Canvas canvas;

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     * 
     * @param url the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvas = new Canvas(100, 100);
        if (userProfilePic != null) {
            try {
                Image defaultImage = new Image(getClass().getResourceAsStream("/images/defaultUser.png"));
                updateProfilePic(defaultImage);
            } catch (NullPointerException e) {
                System.err.println("Default image not found: " + e.getMessage());
            }
        }
    }

    /**
     * Navigates back to the main menu.
     * 
     * @param event the MouseEvent triggered by the user interaction.
     */
    @FXML
    void backToMainMenu(MouseEvent event) {
        try {
            // Load the main menu FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
            Scene mainMenuScene = new Scene(loader.load());
            mainMenuScene.getStylesheets().add(getClass().getResource("/css/mainMenu.css").toExternalForm());

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(mainMenuScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the profile picture with the given image.
     * 
     * @param image the new profile picture image.
     */
    private void updateProfilePic(Image image) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double size = Math.min(image.getWidth(), image.getHeight());
        double x = (image.getWidth() - size) / 2;
        double y = (image.getHeight() - size) / 2;
        double radius = canvas.getWidth() / 2;

        gc.save();

        // Create a circular clip region
        gc.beginPath();
        gc.arc(radius, radius, radius, radius, 0, 360);
        gc.clip();

        // Draw the image on the canvas
        gc.drawImage(image, x, y, size, size, 0, 0, canvas.getWidth(), canvas.getHeight());

        gc.restore();

        // Render the canvas to an Image
        WritableImage imageWithCircle = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
        canvas.snapshot(null, imageWithCircle);

        userProfilePic.setImage(canvas.snapshot(null, null));
    }

    /**
     * Opens a file chooser dialog to select a new profile picture.
     * 
     * @param event the ActionEvent triggered by the user interaction.
     */
    @FXML
    void openFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Picture");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(changeProfilePic.getScene().getWindow());

        if (selectedFile != null) {
            Image newProfileImage = new Image(selectedFile.toURI().toString());
            updateProfilePic(newProfileImage);
        }
    }
}