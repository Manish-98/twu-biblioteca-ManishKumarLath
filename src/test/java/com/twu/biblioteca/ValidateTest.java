package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class ValidateTest {

    @Test
    public void testShouldReturnValidatedUser() {
        User userOne = new User("123-1234", "qwerty");
        User userTwo = new User("123-1235", "qwerty");
        Collection<User> users = new ArrayList<>(Arrays.asList(userOne, userTwo));
        Validate validate = new Validate(users);

        User verifiedUser = validate.getUser("123-1234", "qwerty");

        assertEquals(userOne, verifiedUser);
    }
}