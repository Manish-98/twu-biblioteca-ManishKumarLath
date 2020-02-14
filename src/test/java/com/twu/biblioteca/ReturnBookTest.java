package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReturnBookTest {

    @Test
    public void shouldAllowReturningBook() throws IOException {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Book bookTwo = new Book("Book2", "Author2", 2020);
        Collection<LibraryItems> books = new ArrayList<>(Arrays.asList(bookOne, bookTwo));
        bookOne.checkout();
        when(console.input()).thenReturn("Book1");
        User currentUser = new User("123-1234", "qwerty");
        ReturnBook returnBook = new ReturnBook(console, books, currentUser);

        returnBook.execute();

        assertFalse(bookOne.isCheckedOut());
    }

    @Test
    public void shouldNotAllowReturningBooksNotCheckedOutFromLibrary() throws IOException {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Book bookTwo = new Book("Book2", "Author2", 2020);
        Collection<LibraryItems> books = new ArrayList<>(Arrays.asList(bookOne, bookTwo));
        bookOne.checkout();
        when(console.input()).thenReturn("Book3");
        User currentUser = new User("123-1234", "qwerty");
        ReturnBook returnBook = new ReturnBook(console, books, currentUser);

        returnBook.execute();

        assertTrue(bookOne.isCheckedOut());
        assertFalse(bookTwo.isCheckedOut());
        verify(console, times(1)).output("That is not a valid book to return\n");
    }

    @Test
    public void shouldAllowReturningBookCheckedOutByLoggedInUser() throws IOException {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Collection<LibraryItems> books = new ArrayList<>(Collections.singletonList(bookOne));
        User currentUser = new User("123-1234", "qwerty");
        when(console.input()).thenReturn("Book1");
        CheckoutBook checkoutBook = new CheckoutBook(console, books, currentUser);
        checkoutBook.execute();
        ReturnBook returnBook = new ReturnBook(console, books, currentUser);

        returnBook.execute();

        assertFalse(bookOne.isCheckedOut());
        assertEquals(new ArrayList<>(), currentUser.getCheckedOutBooks());
    }


}