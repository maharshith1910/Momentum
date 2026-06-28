package com.maharshith.backend.dto;

import jakarta.validation.constraints.*;

public class UserRequestDTO {
    @NotBlank(message="Username Cannot be empty")
    private String username;

    @NotBlank(message="Email Cannot be empty")
    @Email(message = "Please enter valid email")
    private String email;

    @NotBlank(message="Password Cannot be empty")
    @Size(min = 8, message = "Password must be on minimum 8 characters")
    private String password;

    public UserRequestDTO() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
