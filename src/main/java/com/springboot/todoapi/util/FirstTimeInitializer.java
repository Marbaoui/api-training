package com.springboot.todoapi.util;

import com.springboot.todoapi.models.AppUser;
import com.springboot.todoapi.services.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstTimeInitializer implements CommandLineRunner {
    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        // check if we have Users
        if (userService.findAll().isEmpty()) {
            logger.info("No users accounts found. Creating some users");
            AppUser user = new AppUser("med@med.med", "password", "med");
            userService.save(user);
        }
        // If no Users exist create some users


    }
}
