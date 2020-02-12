package com.twu.biblioteca;

import java.util.Objects;

public class User {
    private String id;
    private String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public boolean isPasswordCorrect() {
        return true;
    }
}
