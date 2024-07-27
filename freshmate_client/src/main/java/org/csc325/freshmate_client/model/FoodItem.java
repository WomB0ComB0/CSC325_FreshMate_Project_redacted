package org.csc325.freshmate_client.model;

/**
 * Represents a food item with its details such as name, category, image path,
 * and expiration date.
 */
public class FoodItem {
  private String name;
  private String category;
  private String imagePath;
  private String expirationDate;

  /**
   * Constructs a new FoodItem with the specified details.
   * 
   * @param name           the name of the food item.
   * @param category       the category of the food item.
   * @param imagePath      the path to the image of the food item.
   * @param expirationDate the expiration date of the food item.
   */
  public FoodItem(String name, String category, String imagePath, String expirationDate) {
    this.name = name;
    this.category = category;
    this.imagePath = imagePath;
    this.expirationDate = expirationDate;
  }

  /**
   * Gets the name of the food item.
   * 
   * @return the name of the food item.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the food item.
   * 
   * @param name the name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the category of the food item.
   * 
   * @return the category of the food item.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets the category of the food item.
   * 
   * @param category the category to set.
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Gets the image path of the food item.
   * 
   * @return the image path of the food item.
   */
  public String getImagePath() {
    return imagePath;
  }

  /**
   * Sets the image path of the food item.
   * 
   * @param imagePath the image path to set.
   */
  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  /**
   * Gets the expiration date of the food item.
   * 
   * @return the expiration date of the food item.
   */
  public String getExpirationDate() {
    return expirationDate;
  }

  /**
   * Sets the expiration date of the food item.
   * 
   * @param expirationDate the expiration date to set.
   */
  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  /**
   * Returns a string representation of the food item.
   * 
   * @return a string representation of the food item.
   */
  @Override
  public String toString() {
    return "FoodItem{" +
        "name='" + name + '\'' +
        ", category='" + category + '\'' +
        ", imagePath='" + imagePath + '\'' +
        ", expirationDate='" + expirationDate + '\'' +
        '}';
  }
}