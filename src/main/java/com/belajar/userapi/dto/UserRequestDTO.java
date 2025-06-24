package com.belajar.userapi.dto;

public class UserRequestDTO {
    private String name;
    private String email;

    // Constructors
    public UserRequestDTO() {}

    public UserRequestDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
