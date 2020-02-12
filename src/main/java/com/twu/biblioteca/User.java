package com.twu.biblioteca;

import java.util.Objects;

public class User {
    private String id;
    private String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password);
    }
}
