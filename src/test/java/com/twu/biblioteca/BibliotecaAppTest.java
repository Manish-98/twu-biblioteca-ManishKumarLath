package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

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
    private String movieListString;

    public BibliotecaAppTest() {
        welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        menuOut = "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n" +
                "3. Checkout Book\n" +
                "4. Return Book\n" +
                "5. List of available movies\n" +
                "6. Checkout movie\n";

        bookListString = "Harry Potter|JK Rowling|2000\n" +
                "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";

        movieListString = "Movie1|2020|Director1|7.5\n" +
                "Movie2|2020|Director2|8.0\n";

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
        when(stream.input()).thenReturn("10", "2");

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
        when(stream.input()).thenReturn("7", "123-1234", "qwerty", "3", "Harry Potter", "1", "2");
        String modifiedBookList = "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";

        biblioteca.start();

        verify(stream, times(1)).output(modifiedBookList);
    }

    @Test
    public void testShouldNotAllowUsersToCheckoutBooksThatAreNotPresent() throws IOException {
        when(stream.input()).thenReturn("7", "123-1234", "qwerty", "3", "XYZ", "2");

        biblioteca.start();

        verify(stream, times(0)).output(bookListString);
    }

    @Test
    public void testShouldNotifyUserAboutSuccessfulCheckOut() throws IOException {
        when(stream.input()).thenReturn("7", "123-1234", "qwerty", "3", "Harry Potter", "1", "2");

        biblioteca.start();

        verify(stream, times(1)).output(successfulCheckoutMessage);
    }

    @Test
    public void testShouldNotifyUserAboutUnsuccessfulCheckOut() throws IOException {
        when(stream.input()).thenReturn( "7", "123-1234", "qwerty", "3", "XYZ", "2");

        biblioteca.start();

        verify(stream, times(0)).output(bookListString);
        verify(stream, times(1)).output(noBookFoundMessage);
    }

    @Test
    public void testShouldLetUserReturnBook() throws IOException {
        when(stream.input()).thenReturn("7", "123-1234", "qwerty", "3", "Harry Potter", "1", "4", "Harry Potter", "1", "2");
        String newBookList = "Da Vinci Code|Dan Brown|2003\n" +
                "Brida|Paulo Coelho|1990\n";
        biblioteca.start();

        verify(stream, times(1)).output(newBookList);
        verify(stream, times(1)).output(bookListString);
    }

    @Test
    public void testShouldNotifyUserOnSuccessfulBookReturn() throws IOException {
        when(stream.input()).thenReturn("7", "123-1234", "qwerty", "3","Harry Potter", "4", "Harry Potter", "2");
        biblioteca.start();

        verify(stream, times(1)).output(successfulReturnMessage);
    }

    @Test
    public void testShouldNotifyUserOnUnSuccessfulBookReturn() throws IOException {
        when(stream.input()).thenReturn("7", "123-1234", "qwerty", "4", "Harry Potter", "2");
        biblioteca.start();

        verify(stream, times(1)).output(unSuccessfulReturnMessage);
    }

    @Test
    public void testShouldDisplayListOfMovies() throws IOException {
        when(stream.input()).thenReturn("5", "2");

        biblioteca.start();

        verify(stream, times(1)).output(movieListString);
    }


    @Test
    public void testShouldAllowUserToCheckoutMovieFromLibrary() throws IOException {
        when(stream.input()).thenReturn("6", "Movie1", "5", "2");
        String modifiedMovieList = "Movie2|2020|Director2|8.0\n";
        biblioteca.start();

        verify(stream, times(1)).output(modifiedMovieList);
    }

}