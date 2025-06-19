package com.example.service;

import com.example.exception.CustomException;
import com.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User processUser(String userId, String name) throws CustomException {
        logger.trace("Entering processUser with userId: {}, name: {}", userId, name);

        if (userId == null || userId.trim().isEmpty()) {
            logger.warn("Invalid userId provided: {}", userId);
            throw new CustomException("User ID cannot be null or empty");
        }

        try {
            logger.debug("Creating user object for userId: {}", userId);
            User user = new User(userId, name);
            logger.info("Successfully processed user: {}", user.getId());
            return user;
        } catch (Exception e) {
            logger.error("Failed to process user with userId: {}", userId, e);
            throw new CustomException("Error processing user", e);
        } finally {
            logger.trace("Exiting processUser method");
        }
    }
}