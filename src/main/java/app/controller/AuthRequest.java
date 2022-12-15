package app.controller;

import lombok.Data;

@Data
public class AuthRequest {

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String username;
    private String password;

}
