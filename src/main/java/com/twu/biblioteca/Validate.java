package com.twu.biblioteca;

import java.io.IOException;
import java.util.Collection;

public class Validate {
    private Stream console;
    private Collection<User> users;

    public Validate(Stream console, Collection<User> users) {
        this.console = console;
        this.users = users;
    }

    public User getUser() throws IOException {
        console.output(MessageStore.getIdPrompt());
        String id = console.input();
        console.output(MessageStore.getPasswordPrompt());
        String password = console.input();
        User checkingUser = new User(id, password);

        for (User user :
                users) {
            if (user.equals(checkingUser))
                return user;
        }
        return new User("XXX-XXXX", "X");
    }
}
