package org.csc325.freshmate_client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller class for adding items. This class handles the interaction
 * between the user interface and the underlying data model for adding items.
 */
public class addItemController {

  @FXML
  private TextField itemNameField;

  private MainMenuController mainMenuController;

  /**
   * Sets the MainMenuController instance.
   * 
   * @param mainMenuController the MainMenuController instance to be set.
   */
  public void setMainMenuController(MainMenuController mainMenuController) {
    this.mainMenuController = mainMenuController;
  }

  /**
   * Adds an item to the main menu. This method is called when the user
   * interacts with the UI to add an item.
   */
  @FXML
  private void addItem() {
    String itemName = itemNameField.getText();
    mainMenuController.addItem(itemName);
    mainMenuController.loadItems();
    mainMenuController.setSelectedCategory(mainMenuController.getSelectedCategory());
  }
}