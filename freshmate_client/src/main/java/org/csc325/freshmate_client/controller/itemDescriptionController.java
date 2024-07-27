package org.csc325.freshmate_client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.csc325.freshmate_client.model.FoodItem;

/**
 * Controller class for displaying item descriptions. This class handles the
 * interaction between the user interface and the underlying data model for
 * displaying details of a food item.
 */
public class itemDescriptionController {
    @FXML
    private Label itemNameLabel;
    
    @FXML
    private Label categoryLabel;
    
    @FXML
    private Label expirationDateLabel;
    
    @FXML
    private ImageView itemImageView;
    
    private FoodItem foodItem;
    
    /**
     * Sets the FoodItem instance and updates the UI with its details.
     * 
     * @param foodItem the FoodItem instance to be set.
     */
    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
        updateUI();
    }
    
    /**
     * Updates the UI with the details of the current FoodItem.
     * This method sets the text of the labels to the name, category,
     * and expiration date of the food item.
     */
    private void updateUI() {
        if (foodItem != null) {
            itemNameLabel.setText(foodItem.getName());
            categoryLabel.setText(foodItem.getCategory());
            expirationDateLabel.setText(foodItem.getExpirationDate());
        }
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     */
    @FXML
    private void initialize() {}
}