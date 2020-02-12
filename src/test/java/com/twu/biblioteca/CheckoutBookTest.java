package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CheckoutBookTest {

    @Test
    public void testShouldCheckOutBookRequestedByUser() throws IOException {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Book bookTwo = new Book("Book2", "Author2", 2020);
        Book bookThree = new Book("Book3", "Author3", 2020);
        Collection<Book> books = new ArrayList<>(Arrays.asList(bookOne, bookTwo, bookThree));
        GetListOfBooks getListOfBooks = new GetListOfBooks(console);
        when(console.input()).thenReturn("Book1");
        CheckoutBook checkoutBook = new CheckoutBook(console);

        checkoutBook.execute(books);
        getListOfBooks.execute(books);


        verify(console, times(1)).output("Book2|Author2|2020\n" +
                "Book3|Author3|2020\n");
    }

    @Test
    public void testShouldNotCheckOutBookNotPresentInLibrary() throws IOException {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Collection<Book> books = new ArrayList<>(Collections.singletonList(bookOne));
        CheckoutBook checkoutBook = new CheckoutBook(console);
        GetListOfBooks getListOfBooks = new GetListOfBooks(console);
        when(console.input()).thenReturn("Book2");

        checkoutBook.execute(books);
        getListOfBooks.execute(books);

        verify(console, times(1)).output("Book1|Author1|2020\n");
    }
}