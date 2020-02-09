package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void testWelcomeMessageDisplayedOnStartUp() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(expectedMessage, biblioteca.getWelcomeMessage());
    }

    @Test
    public void testListOfBooksDisplayedAfterWelcomeMessage() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        String expectedList = "Harry Potter\nDa Vinci Code\nBrida\n";

        assertEquals(expectedList, biblioteca.getBookList());
    }
}