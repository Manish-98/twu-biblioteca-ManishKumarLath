package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidateTest {

    @Test
    public void testShouldReturnValidatedUser() throws IOException {
        Stream console = mock(Stream.class);
        User userOne = new User("123-1234", "qwerty");
        User userTwo = new User("123-1235", "qwerty");
        Collection<User> users = new ArrayList<>(Arrays.asList(userOne, userTwo));
        when(console.input()).thenReturn("123-1234", "qwerty");
        Validate validate = new Validate(console, users);

        User verifiedUser = validate.getUser();

        assertEquals(userOne, verifiedUser);
    }
}