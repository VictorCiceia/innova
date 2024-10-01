package com.innova.innova.dto;

public class UserDto {

    private String id;

    private String name;

    private String email;

    public UserDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
