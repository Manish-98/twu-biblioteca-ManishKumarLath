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
        System.setIn(System.in);
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
        System.setIn(new ByteArrayInputStream("1\n2".getBytes()));
        String menuOut = "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n" +
                "3. Checkout Book\n\n";
        String bookListString = "Harry Potter|JK Rowling|2000\n" +
                "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";
        String exitMessage = "Quiting Application...\n";
        String expectedOutput = menuOut + bookListString + "\n" + menuOut + exitMessage;
        biblioteca.showMenu();

        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testShouldDisplayErrorMessageWhenInvalidOptionIsSelectedByUser() throws IOException {
        System.setIn(new ByteArrayInputStream("4\n2".getBytes()));
        String menuOut = "Select an option:\n" +
                "1. List of books\n"+
                "2. Quit Application\n" +
                "3. Checkout Book\n\n";
        String errorMessage = "Please select a valid option!\n";
        String exitMessage = "Quiting Application...\n";
        String expectedOutput = menuOut + errorMessage + menuOut + exitMessage;
        biblioteca.showMenu();

        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testShouldQuitApplicationWhenUserChoosesToQuit() throws IOException {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        String menuOut = "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n" +
                "3. Checkout Book\n\n";
        String exitMessage = "Quiting Application...\n";
        String expectedOutput = menuOut + exitMessage;
        biblioteca.showMenu();

        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testShouldNotQuitUnlessUserSelectsOptionToQuit() throws IOException {
        String testInputs = "4\n2";
        System.setIn(new ByteArrayInputStream(testInputs.getBytes()));
        String menuOut = "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n" +
                "3. Checkout Book\n\n";
        String errorMessage = "Please select a valid option!\n";
        String exitMessage = "Quiting Application...\n";
        String expectedMessage = menuOut + errorMessage + menuOut + exitMessage;

        biblioteca.showMenu();

        assertEquals(expectedMessage, output.toString());
    }

    @Test
    public void testShouldAllowUsersToCheckoutBook() throws IOException {
        String testInputs = "3\nHarry Potter\n1\n2";
        System.setIn(new ByteArrayInputStream(testInputs.getBytes()));
        String menuOut = "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n" +
                "3. Checkout Book\n\n";
        String checkoutMessage = "Enter the name of the book to be checked out:\n";
        String exitMessage = "Quiting Application...\n";
        String bookListString = "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n\n";
        String expectedMessage = menuOut + checkoutMessage + menuOut + bookListString + menuOut + exitMessage;

        biblioteca.showMenu();

        assertEquals(expectedMessage, output.toString());
    }
}