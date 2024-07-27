module org.csc325.freshmate_client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires transitive javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    requires com.google.auth.oauth2;
    requires transitive google.cloud.firestore;
    requires firebase.admin;
    requires com.google.api.apicommon;
    requires google.cloud.core;
    requires com.google.auth;
    requires spring.web;
    requires spring.core;

    opens org.csc325.freshmate_client.controller to javafx.fxml;
    opens org.csc325.freshmate_client.model to com.google.cloud.firestore, google.cloud.core;

    exports org.csc325.freshmate_client;
    exports org.csc325.freshmate_client.controller to javafx.fxml;
    exports org.csc325.freshmate_client.model to com.google.cloud.firestore;
}