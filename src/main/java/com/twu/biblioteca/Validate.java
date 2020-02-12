package com.twu.biblioteca;

import java.util.Collection;

public class Validate {
    private Collection<User> users;

    public Validate(Collection<User> users) {
        this.users = users;
    }

    public User getUser(String id, String password) {
        for (User user :
                users) {
            if (user.equals(new User(id, password)))
                return user;
        }

        return new User("XXX-XXXX", "X");
    }
}
