package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

// TODO - BibliotecaApp has to be a god class
// TODO - Test cases are neat
// TODO - However all tests need to happen by verifications of side effects - which sucks
// TODO - why this sucks - because every logic is verified through the top layer, so everything is coupled through the top layer.
// TODO - lets change the options from 1,2,3.... to A,B,C - we are screwed.
// TODO - should this change (1,2,3 -> A,B,C) have any effect on my confidence levels of whether checkout works properly or not
// TODO - unfortunately, it does have effect - leads to failing tests.
// TODO - everything is coupled to the user interactions, any change in user interactions changes everything.
public class BibliotecaAppTest {

    private final String menuOut;
    private final String welcomeMessage;
    private final String bookListString;
    private final String noBookFoundMessage;
    private final String invalidOptionMessage;
    private final String quitMessage;
    private final String successfulCheckoutMessage;
    private final String successfulReturnMessage;
    private final String unSuccessfulReturnMessage;
    private BibliotecaApp biblioteca;
    private Stream stream;

    public BibliotecaAppTest() {
        welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        menuOut = "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n" +
                "3. Checkout Book\n" +
                "4. Return Book\n";

        bookListString = "Harry Potter|JK Rowling|2000\n" +
                "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";

        quitMessage = "Quiting Application...";
        invalidOptionMessage = "Please select a valid option!\n";
        noBookFoundMessage = "Sorry, that book is not available\n";
        successfulCheckoutMessage = "Thank you! Enjoy the book\n";
        successfulReturnMessage = "Thank you for returning the book\n";
        unSuccessfulReturnMessage = "That is not a valid book to return\n";
    }

    @Before
    public void setup() {
        stream = mock(Stream.class);
        biblioteca = new BibliotecaApp(stream);
    }

    @Test
    public void testWelcomeMessageDisplayedOnStartUp() throws IOException {
        when(stream.input()).thenReturn("2");
        biblioteca.start();


        verify(stream, times(1)).output(welcomeMessage);
    }

    @Test
    public void testShouldDisplayListOfBooksIfUserChoosesItInMenu() throws IOException {
        when(stream.input()).thenReturn("1", "2");

        biblioteca.start();

        verify(stream, times(1)).output(welcomeMessage);
        verify(stream, times(1)).output(bookListString);
    }

    @Test
    public void testShouldDisplayMenuAfterWelcomeMessage() throws IOException {
        when(stream.input()).thenReturn("2");

        biblioteca.start();

        verify(stream, times(1)).output(welcomeMessage);
        verify(stream, times(1)).output(menuOut);
    }

    @Test
    public void testShouldDisplayErrorMessageWhenInvalidOptionIsSelectedByUser() throws IOException {
        when(stream.input()).thenReturn("5", "2");

        biblioteca.start();

        verify(stream, times(1)).output(invalidOptionMessage);
    }

    @Test
    public void testShouldQuitApplicationWhenUserChoosesToQuit() throws IOException {
        when(stream.input()).thenReturn("2");

        biblioteca.start();

        verify(stream, times(1)).output(quitMessage);
    }

    @Test
    public void testShouldNotQuitUnlessUserSelectsOptionToQuit() throws IOException {
        when(stream.input()).thenReturn("1", "2");

        biblioteca.start();

        verify(stream, times(1)).output(bookListString);
        verify(stream, times(1)).output(quitMessage);
    }

    @Test
    public void testShouldAllowUsersToCheckoutBook() throws IOException {
        when(stream.input()).thenReturn("3", "Harry Potter", "1", "2");
        String modifiedBookList = "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";

        biblioteca.start();

        verify(stream, times(1)).output(modifiedBookList);
    }

    @Test
    public void testShouldNotAllowUsersToCheckoutBooksThatAreNotPresent() throws IOException {
        when(stream.input()).thenReturn("3", "XYZ", "2");

        biblioteca.start();

        verify(stream, times(0)).output(bookListString);
    }

    @Test
    public void testShouldNotifyUserAboutSuccessfulCheckOut() throws IOException {
        when(stream.input()).thenReturn("3", "Harry Potter", "1", "2");

        biblioteca.start();

        verify(stream, times(1)).output(successfulCheckoutMessage);
    }

    @Test
    public void testShouldNotifyUserAboutUnsuccessfulCheckOut() throws IOException {
        when(stream.input()).thenReturn("3", "XYZ", "2");

        biblioteca.start();

        verify(stream, times(0)).output(bookListString);
        verify(stream, times(1)).output(noBookFoundMessage);
    }

    @Test
    public void testShouldLetUserReturnBook() throws IOException {
        when(stream.input()).thenReturn("3", "Harry Potter", "1", "4", "Harry Potter", "1", "2");
        String newBookList = "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";
        biblioteca.start();

        verify(stream, times(1)).output(newBookList);
        verify(stream, times(1)).output(bookListString);
    }

    @Test
    public void testShouldNotifyUserOnSuccessfulBookReturn() throws IOException {
        when(stream.input()).thenReturn("3", "Harry Potter", "4", "Harry Potter", "2");
        biblioteca.start();

        verify(stream, times(1)).output(successfulReturnMessage);
    }

    @Test
    public void testShouldNotifyUserOnUnSuccessfulBookReturn() throws IOException {
        when(stream.input()).thenReturn("4", "Harry Potter", "2");
        biblioteca.start();

        verify(stream, times(1)).output(unSuccessfulReturnMessage);
    }


}