package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testShouldReturnTrueIfTheBookNameIsSameAsStringParameter() {
        Book bookOne = new Book("Book1", "Author1", 1990);

        assertTrue(bookOne.hasName("Book1"));
    }

    @Test
    public void testShouldReturnFalseIfTheBookNameDoesNotMatchStringParameter() {
        Book bookOne = new Book("Book1", "Author1", 1990);

        assertFalse(bookOne.hasName("Book2"));
    }

    @Test
    public void testShouldReturnBookDetailsAString() {
        Book bookOne = new Book("Book1", "Author1", 1990);

        assertEquals("Book1|Author1|1990\n", bookOne.toString());
    }
}