package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testShouldReturnTrueIfPasswordEnteredIsCorrect() {
        User user = new User("123-1234", "qwerty");

        assertTrue(user.equals(new User("123-1234", "qwerty")));
    }

    @Test
    public void testShouldReturnFalseIfPasswordEnteredIsIncorrect() {
        User user = new User("123-1234", "qwerty");

        assertFalse(user.equals(new User("123-1235", "qwerty")));
    }
}