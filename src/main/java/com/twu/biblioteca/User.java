package com.twu.biblioteca;

public class User {
    private String id;
    private String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }
}
