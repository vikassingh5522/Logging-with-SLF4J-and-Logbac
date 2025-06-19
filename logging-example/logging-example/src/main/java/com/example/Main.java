package com.example;

import com.example.exception.CustomException;
import com.example.model.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application started");

        UserService userService = new UserService();

        try {
            // Successful case
            User user = userService.processUser("123", "John Doe");
            logger.info("Created user: {} with name: {}", user.getId(), user.getName());

            // Error case
            userService.processUser(null, "Jane Doe");
        } catch (CustomException e) {
            logger.error("Application error occurred", e);
        }

        logger.info("Application shutdown");
    }
}