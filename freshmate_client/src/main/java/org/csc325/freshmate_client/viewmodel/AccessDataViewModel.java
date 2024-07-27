package org.csc325.freshmate_client.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * ViewModel class for accessing and managing user data properties.
 * This class provides properties for user name, email, and a flag indicating
 * whether writing is possible.
 */
public class AccessDataViewModel {
    private final StringProperty userName = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final BooleanProperty isWritePossible = new SimpleBooleanProperty();

    /**
     * Gets the user name property.
     * 
     * @return the user name property.
     */
    public StringProperty userNameProperty() {
        return userName;
    }

    /**
     * Gets the email property.
     * 
     * @return the email property.
     */
    public StringProperty emailProperty() {
        return email;
    }

    /**
     * Gets the property indicating whether writing is possible.
     * 
     * @return the property indicating whether writing is possible.
     */
    public BooleanProperty isWritePossibleProperty() {
        return isWritePossible;
    }
}