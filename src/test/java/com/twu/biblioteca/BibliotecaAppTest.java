package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    BibliotecaApp biblioteca;

    @Before
    public void setup() {
        biblioteca = new BibliotecaApp();
    }

    @Test
    public void testWelcomeMessageDisplayedOnStartUp() {
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(expectedMessage, biblioteca.getWelcomeMessage());
    }

    @Test
    public void testShouldReturnBookNameAuthorPublishingYearAfterWelcomeMessage() {
        String bookList = "Harry Potter|JK Rowling|2000\n" +
                "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";

        assertEquals(bookList, biblioteca.getBookList());
    }


}