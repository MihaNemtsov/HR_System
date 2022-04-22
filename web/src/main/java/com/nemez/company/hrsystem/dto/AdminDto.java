package com.nemez.company.hrsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nemez.company.hrsystem.model.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminDto {
    private Integer id;
    private String username;
    private String password;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }

    public static AdminDto fromUser(User user) {
        AdminDto userDto = new AdminDto();

        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
