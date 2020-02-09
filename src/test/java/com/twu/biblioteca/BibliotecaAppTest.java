package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    BibliotecaApp biblioteca;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;

    @Before
    public void setup() {
        biblioteca = new BibliotecaApp();
        System.setOut(new PrintStream(output));
    }

    @After
    public void reset() {
        System.setOut(originalOutput);
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

    @Test
    public void testShouldDisplayListOfBooksIfUserChoosesItInMenu() throws IOException {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        String menuOut = "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n\n";
        String bookListString = "Harry Potter|JK Rowling|2000\n" +
                "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";
        String expectedOutput = menuOut + bookListString + "\n";
        biblioteca.showMenu();

        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testShouldDisplayErrorMessageWhenInvalidOptionIsSelectedByUser() throws IOException {
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        String menuOut = "Select an option:\n" +
                "1. List of books\n"+
                "2. Quit Application\n\n";
        String errorMessage = "Please select a valid option!\n";
        String expectedOutput = menuOut + errorMessage;
        biblioteca.showMenu();

        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testShouldQuitApplicationWhenUserChoosesToQuit() throws IOException {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        String menuOut = "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n\n";
        String exitMessage = "Quiting Application...\n";
        String expectedOutput = menuOut + exitMessage;
        biblioteca.showMenu();

        assertEquals(expectedOutput, output.toString());
    }
}