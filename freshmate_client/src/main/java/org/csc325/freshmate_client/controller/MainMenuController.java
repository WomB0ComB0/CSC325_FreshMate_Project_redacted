package org.csc325.freshmate_client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import org.csc325.freshmate_client.model.FoodItem;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for the main menu. This class handles the interaction
 * between the user interface and the underlying data model for the main menu.
 */
public class MainMenuController implements Initializable {
    @FXML
    private Button PantryBtn;

    @FXML
    private VBox categoryContainer;

    @FXML
    private Button freezerBtn;

    @FXML
    private ScrollPane freezerScrollPane;

    @FXML
    private Button fridgeBtn;

    @FXML
    private ScrollPane fridgeScrollPane;

    @FXML
    private ScrollPane pantryScrollPane;

    @FXML
    private TextField searchBar;

    @FXML
    private Label usersNameLabel;

    @FXML
    private VBox fridgeVBox;
    @FXML
    private VBox freezerVBox;
    @FXML
    private VBox pantryVBox;

    @FXML
    private ImageView userPhoto;

    @FXML
    private Button addItem;

    private List<FoodItem> foodItems = new ArrayList<>();

    private String selectedCategory;

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     * 
     * @param location  The location used to resolve relative paths for the root
     *                  object, or null if the location is not known.
     * @param resources The resources used to localize the root object, or null if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (userPhoto != null) {
            userPhoto.setFitWidth(80);
            userPhoto.setFitHeight(80);
            userPhoto.setPreserveRatio(true);

            Circle clip = new Circle(40, 40, 40);
            userPhoto.setClip(clip);

            userPhoto.setEffect(new DropShadow(10, Color.BLACK));
        }

        VBox.setVgrow(fridgeVBox, Priority.ALWAYS);
        VBox.setVgrow(freezerVBox, Priority.ALWAYS);
        VBox.setVgrow(pantryVBox, Priority.ALWAYS);

        showFridge();

        addNewFoodItem("fridge", "Dairy", "/images/food_items/lactaid_milk.png", "2 days left");
        addNewFoodItem("fridge", "Dairy", "/images/food_items/butter.png", "5 days left");
        addNewFoodItem("pantry", "Cereal", "/images/food_items/rice-krispies.png", "Expires in 30 days");
        addNewFoodItem("fridge", "Dairy", "/images/food_items/sour_cream.png", "1 day left");
        addNewFoodItem("fridge", "Dairy", "/images/food_items/eggs.png", "9 days left");
        addNewFoodItem("fridge", "Fruit", "/images/food_items/strawberries.png", "2 days left");
        addNewFoodItem("freezer", "Meat", "/images/food_items/chicken_breast.png", "7 days left");
        addNewFoodItem("fridge", "Vegetable", "/images/food_items/shredded_lettuce.png", "3 days left");
    }

    /**
     * Displays the user profile page.
     * 
     * @param event the MouseEvent triggered by the user interaction.
     */
    @FXML
    void showUserProfile(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/csc325/freshmate_client/userProfile.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) userPhoto.getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a category section VBox.
     * 
     * @param category the name of the category.
     * @return the created VBox for the category section.
     */
    private VBox createCategorySection(String category) {
        Label categoryLabel = new Label(category);
        categoryLabel.setPrefHeight(18);
        categoryLabel.setPrefWidth(200);
        categoryLabel.setPadding(new Insets(10, 0, 0, 20));
        categoryLabel.getStyleClass().add("category-label");

        HBox labelHBox = new HBox(categoryLabel);
        labelHBox.setAlignment(Pos.CENTER_LEFT);
        labelHBox.setPrefHeight(33);
        labelHBox.setPrefWidth(391);

        HBox itemsHBox = new HBox();
        itemsHBox.setSpacing(10);
        itemsHBox.setPrefHeight(196);
        itemsHBox.setPrefWidth(391);
        itemsHBox.setMinHeight(196);
        itemsHBox.setMinWidth(391);

        ScrollPane itemsScrollPane = new ScrollPane(itemsHBox);
        itemsScrollPane.setPrefHeight(213);
        itemsScrollPane.setPrefWidth(376);
        itemsScrollPane.setFitToWidth(true);
        itemsScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        itemsScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        itemsScrollPane.getStyleClass().add("item-scroll-pane");

        VBox categoryVBox = new VBox(labelHBox, itemsScrollPane);
        categoryVBox.setPrefHeight(249);
        categoryVBox.setPrefWidth(391);
        VBox.setMargin(itemsScrollPane, new Insets(0, 10, 0, 10));

        VBox.setVgrow(categoryVBox, Priority.ALWAYS);

        return categoryVBox;
    }

    /**
     * Adds a category section to the specified main category.
     * 
     * @param mainCategory the main category (e.g., "fridge", "freezer", "pantry").
     * @param category     the subcategory to be added.
     */
    public void addCategorySection(String mainCategory, String category) {
        VBox categoryVBox = createCategorySection(category);

        switch (mainCategory.toLowerCase()) {
            case "fridge":
                fridgeVBox.getChildren().add(categoryVBox);
                break;
            case "freezer":
                freezerVBox.getChildren().add(categoryVBox);
                break;
            case "pantry":
                pantryVBox.getChildren().add(categoryVBox);
                break;
        }
    }

    /**
     * Creates an item VBox with the specified image and expiration text.
     * 
     * @param imagePath      the path to the image.
     * @param expirationText the expiration text.
     * @return the created VBox for the item.
     */
    private VBox createItemVBox(String imagePath, String expirationText) {
        Image image = null;
        try {
            URL imageUrl = getClass().getResource(imagePath);
            if (imageUrl == null) {
                throw new IllegalArgumentException("Image URL is null for path: " + imagePath);
            }
            image = new Image(imageUrl.toExternalForm());
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            image = new Image(getClass().getResource("/images/default.png").toExternalForm());
        }

        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(150);
        imageView.setFitWidth(111);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        Label expirationLabel = new Label(expirationText);
        expirationLabel.setPrefHeight(31);
        expirationLabel.setPrefWidth(152);
        expirationLabel.setAlignment(javafx.geometry.Pos.CENTER);

        VBox itemVBox = new VBox(imageView, expirationLabel);
        itemVBox.setPrefHeight(200);
        itemVBox.setPrefWidth(126);
        VBox.setMargin(imageView, new Insets(0, 0, 20, 0));
        itemVBox.setAlignment(Pos.BOTTOM_CENTER);
        itemVBox.setSpacing(0);

        return itemVBox;
    }

    /**
     * Adds an item to the specified category in the main category.
     * 
     * @param mainCategory   the main category (e.g., "fridge", "freezer",
     *                       "pantry").
     * @param category       the subcategory.
     * @param imagePath      the path to the image.
     * @param expirationText the expiration text.
     */
    public void addItemToCategory(String mainCategory, String category, String imagePath, String expirationText) {

        VBox itemVBox = createItemVBox(imagePath, expirationText);
        System.out.println("Item VBox Created: " + itemVBox);

        VBox targetVBox = null;

        switch (mainCategory.toLowerCase()) {
            case "fridge":
                targetVBox = findCategoryVBox(fridgeVBox, category);
                break;
            case "freezer":
                targetVBox = findCategoryVBox(freezerVBox, category);
                break;
            case "pantry":
                targetVBox = findCategoryVBox(pantryVBox, category);
                break;
        }

        if (targetVBox != null) {
            HBox itemsHBox = (HBox) ((ScrollPane) targetVBox.getChildren().get(1)).getContent();
            itemsHBox.getChildren().add(itemVBox);
        }
    }

    /**
     * Finds the VBox for the specified category in the main VBox.
     * 
     * @param mainVBox the main VBox.
     * @param category the category to find.
     * @return the VBox for the specified category, or null if not found.
     */
    private VBox findCategoryVBox(VBox mainVBox, String category) {
        for (Node node : mainVBox.getChildren()) {
            if (node instanceof VBox) {
                VBox vbox = (VBox) node;
                HBox labelHBox = (HBox) vbox.getChildren().get(0);
                Label label = (Label) labelHBox.getChildren().get(0);
                if (label.getText().equalsIgnoreCase(category)) {
                    return vbox;
                }
            }
        }
        return null;
    }

    /**
     * Adds a new food item to the specified category in the main category.
     * 
     * @param mainCategory   the main category (e.g., "fridge", "freezer",
     *                       "pantry").
     * @param category       the subcategory.
     * @param imagePath      the path to the image.
     * @param expirationText the expiration text.
     */
    public void addNewFoodItem(String mainCategory, String category, String imagePath, String expirationText) {

        boolean categoryExists = false;

        VBox targetVBox = null;
        switch (mainCategory.toLowerCase()) {
            case "fridge":
                targetVBox = findCategoryVBox(fridgeVBox, category);
                break;
            case "freezer":
                targetVBox = findCategoryVBox(freezerVBox, category);
                break;
            case "pantry":
                targetVBox = findCategoryVBox(pantryVBox, category);
                break;
        }

        if (targetVBox != null) {
            categoryExists = true;
        }

        if (!categoryExists) {
            addCategorySection(mainCategory, category);
        }

        addItemToCategory(mainCategory, category, imagePath, expirationText);
    }

    /**
     * Displays the fridge items.
     */
    @FXML
    private void showFridge() {
        fridgeScrollPane.setVisible(true);
        freezerScrollPane.setVisible(false);
        pantryScrollPane.setVisible(false);
        if (((VBox) fridgeScrollPane.getContent()).getChildren().isEmpty()) {
            displayNoItemsMessage("fridge");
        }
    }

    /**
     * Displays the freezer items.
     */
    @FXML
    private void showFreezer() {
        fridgeScrollPane.setVisible(false);
        freezerScrollPane.setVisible(true);
        pantryScrollPane.setVisible(false);
        if (((VBox) freezerScrollPane.getContent()).getChildren().isEmpty()) {
            displayNoItemsMessage("freezer");
        }
    }

    /**
     * Displays the pantry items.
     */
    @FXML
    private void showPantry() {
        fridgeScrollPane.setVisible(false);
        freezerScrollPane.setVisible(false);
        pantryScrollPane.setVisible(true);
        if (((VBox) pantryScrollPane.getContent()).getChildren().isEmpty()) {
            displayNoItemsMessage("pantry");
        }
    }

    /**
     * Displays a message indicating that there are no items in the specified
     * category.
     * 
     * @param category the category to display the message for.
     */
    private void displayNoItemsMessage(String category) {
        VBox categoryVBox;
        switch (category.toLowerCase()) {
            case "fridge":
                categoryVBox = fridgeVBox;
                break;
            case "freezer":
                categoryVBox = freezerVBox;
                break;
            case "pantry":
                categoryVBox = pantryVBox;
                break;
            default:
                return;
        }

        if (categoryVBox.getChildren().isEmpty()) {
            Label messageLabel = new Label("There are no items in your " + category + ". Would you like to add some?");
            messageLabel.setWrapText(true);
            messageLabel.setTextAlignment(TextAlignment.CENTER);
            categoryVBox.getChildren().add(messageLabel);
            VBox.setMargin(messageLabel, new Insets(20, 20, 20, 20));
            VBox.setVgrow(messageLabel, Priority.ALWAYS);
            categoryVBox.setAlignment(Pos.CENTER);
        }
    }

    /**
     * Displays the add item page.
     * 
     * @param event the ActionEvent triggered by the user interaction.
     */
    @FXML
    void showAddItem(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/csc325/freshate_client/addItem.fxml"));
            Parent root = loader.load();

            addItemController addItemController = loader.getController();
            addItemController.setMainMenuController(this);

            Stage stage = (Stage) addItem.getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds an item to the backend.
     * 
     * @param itemName the name of the item to be added.
     */
    public void addItem(String itemName) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/items";
            restTemplate.postForEntity(url, itemName, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads items from the backend.
     */
    public void loadItems() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/items";
        ResponseEntity<List<FoodItem>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FoodItem>>() {
                });
        List<FoodItem> items = response.getBody();
        System.out.println(items);
    }

    /**
     * Gets the selected grocery item from the backend.
     * 
     * @param itemName the name of the item to be retrieved.
     */
    public void getSelectedGrocery(String itemName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/items/" + itemName;
        FoodItem item = restTemplate.getForObject(url, FoodItem.class);
        System.out.println(item);
    }

    /**
     * Gets the selected category.
     * 
     * @return the selected category.
     */
    public String getSelectedCategory() {
        return selectedCategory;
    }

    /**
     * Sets the selected category.
     * 
     * @param selectedCategory the selected category to be set.
     */
    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}