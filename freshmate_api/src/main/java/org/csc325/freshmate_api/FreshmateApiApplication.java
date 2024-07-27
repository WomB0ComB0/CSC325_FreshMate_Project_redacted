package org.csc325.freshmate_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Freshmate API application.
 * @author Mike Odnis
 * @version 1.0
 * @since 1.0
 * @category Freshmate API
 * @see org.csc325.freshmate_api.web
 * @see org.csc325.freshmate_api.service
 * @see org.csc325.freshmate_api.repository
 * @see org.csc325.freshmate_api.model
 */
@SpringBootApplication
public class FreshmateApiApplication {

	/**
	 * Main method for the Freshmate API application.
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(FreshmateApiApplication.class, args);
	}

}
