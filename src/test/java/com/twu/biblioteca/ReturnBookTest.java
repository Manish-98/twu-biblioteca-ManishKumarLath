package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ReturnBookTest {

    @Test
    public void shouldAllowReturningBook() throws IOException {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Book bookTwo = new Book("Book2", "Author2", 2020);
        Collection<Book> books = new ArrayList<>(Arrays.asList(bookOne, bookTwo));
        bookOne.checkout();
        when(console.input()).thenReturn("Book1");
        ReturnBook returnBook = new ReturnBook(console);

        returnBook.execute(books);

        assertFalse(bookOne.isCheckedOut());
    }

    @Test
    public void shouldNotAllowReturningBooksNotCheckedOutFromLibrary() throws IOException {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Book bookTwo = new Book("Book2", "Author2", 2020);
        Collection<Book> books = new ArrayList<>(Arrays.asList(bookOne, bookTwo));
        bookOne.checkout();
        when(console.input()).thenReturn("Book3");
        ReturnBook returnBook = new ReturnBook(console);

        returnBook.execute(books);

        assertTrue(bookOne.isCheckedOut());
        assertFalse(bookTwo.isCheckedOut());
        verify(console, times(1)).output("That is not a valid book to return\n");
    }
}