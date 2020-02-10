package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private BibliotecaApp biblioteca;
    private Stream stream;

    private final String menuOut;
    private final String welcomeMessage;
    private final String bookListString;
    private String invalidOptionMessage;
    private String quitMessage;
    private String checkoutMessage;
    String noBookFoundMessage;

    public BibliotecaAppTest() {
        welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        menuOut = "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n" +
                "3. Checkout Book\n";

        bookListString = "Harry Potter|JK Rowling|2000\n" +
                "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";

        quitMessage = "Quiting Application...";
        invalidOptionMessage = "Please select a valid option!\n";
        checkoutMessage = "Enter the name of the book to be checked out:\n";
        noBookFoundMessage = "Book Not Found\n";
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
        when(stream.input()).thenReturn("1","2");

        biblioteca.start();

        verify(stream, times(1)).output(bookListString);
        verify(stream, times(1)).output(quitMessage);
    }

    @Test
    public void testShouldAllowUsersToCheckoutBook() throws IOException {
        when(stream.input()).thenReturn("3","Harry Potter","1","2");
        String modifiedBookList = "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";

        biblioteca.start();

        verify(stream, times(1)).output(modifiedBookList);
    }

    @Test
    public void testShouldNotAllowUsersToCheckoutBooksThatAreNotPresent() throws IOException {
        when(stream.input()).thenReturn("3","XYZ","2");

        biblioteca.start();

        verify(stream, times(1)).output(noBookFoundMessage);
    }
}