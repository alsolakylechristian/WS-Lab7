package com.alsolakyle.lab7.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int UID;
    private String username;
    private String password;
    private boolean enabled;

    @RestController // Indicates this class handles REST requests
    @RequestMapping("/api/v1/users") // Sets the base URL endpoint
    public static class UserController {

        @GetMapping // Maps HTTP GET requests to this method
        public User getUser() {
            // Build and return a static user for testing
            return builder()
                    .username("blueJava")
                    .password("thisIsAPassword!")
                    .enabled(false)
                    .UID(0)
                    .build();
        }
    }
}
