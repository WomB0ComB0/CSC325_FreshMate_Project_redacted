package org.csc325.freshmate_client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import org.csc325.freshmate_client.model.FireStoreContext;

/**
 * HelloApplication is the main entry point for the JavaFX application.
 * It initializes Firebase and loads the initial FXML layout.
 * 
 * @autor Mike Odnis
 */
public class HelloApplication extends Application {

    /**
     * Default constructor.
     */
    public HelloApplication() {
        super();
    }

    /**
     * The main entry point for all JavaFX applications. The start method is called after the
     * init method has returned, and after the system is ready for the application to begin running.
     * 
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * @throws IOException if the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FireStoreContext.initialize();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/csc325/freshmate_client/signUpPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("hi");
    }

    /**
     * The main method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     * 
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}