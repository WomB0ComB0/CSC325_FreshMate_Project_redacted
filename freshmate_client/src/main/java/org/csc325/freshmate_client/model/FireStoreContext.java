package org.csc325.freshmate_client.model;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.auth.FirebaseAuth;
import java.io.IOException;
import java.io.InputStream;

/**
 * FireStoreContext is a utility class that initializes and provides access to Firebase services.
 * It initializes Firebase with the provided service account credentials and provides methods
 * to get instances of Firestore and FirebaseAuth.
 * 
 * @author Mike Odnis
 */
public class FireStoreContext {

    private static FirebaseAuth firebaseAuth;
    private static Firestore firestore;

    /**
     * Initializes Firebase with the service account credentials.
     * 
     * @throws IOException if the service account key file is not found or cannot be read.
     */
    public static void initialize() throws IOException {
        try (InputStream serviceAccount = FireStoreContext.class.getResourceAsStream("/json/env.json")) {
            if (serviceAccount == null) {
                throw new IOException("Firebase service account key file not found");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase is initialized");
        }
    }

    /**
     * Returns an instance of Firestore. If Firestore is not initialized, it initializes it.
     * 
     * @return an instance of Firestore.
     */
    public static Firestore getFirestore() {
        if (firestore == null) {
            firestore = FirestoreClient.getFirestore();
        }
        return firestore;
    }

    /**
     * Returns an instance of FirebaseAuth. If FirebaseAuth is not initialized, it initializes it.
     * 
     * @return an instance of FirebaseAuth.
     */
    public static FirebaseAuth getFirebaseAuth() {
        if (firebaseAuth == null) {
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }
}