package com.abeetek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the API Key Auth Provider service.
 *
 * This class bootstraps the Spring Boot application.
 *
 * @author Yahya Kamran
 */
@SpringBootApplication
public class ApiKeyAuthProviderApplication {

    /**
     * Main method to start the Spring Boot application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiKeyAuthProviderApplication.class, args);
    }

}