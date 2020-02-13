package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CheckoutBookTest {

    @Test
    public void testShouldCheckOutBookRequestedByUser() throws IOException {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Book bookTwo = new Book("Book2", "Author2", 2020);
        Book bookThree = new Book("Book3", "Author3", 2020);
        Collection<LibraryItems> books = new ArrayList<>(Arrays.asList(bookOne, bookTwo, bookThree));
        when(console.input()).thenReturn("Book1");
        CheckoutBook checkoutBook = new CheckoutBook(console, books);

        checkoutBook.execute();

        assertTrue(bookOne.isCheckedOut());
        assertFalse(bookTwo.isCheckedOut());
        assertFalse(bookThree.isCheckedOut());

    }

    @Test
    public void testShouldNotCheckOutBookNotPresentInLibrary() throws IOException {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Collection<LibraryItems> books = new ArrayList<>(Collections.singletonList(bookOne));
        CheckoutBook checkoutBook = new CheckoutBook(console, books);
        when(console.input()).thenReturn("Book2");

        checkoutBook.execute();

        assertFalse(bookOne.isCheckedOut());
    }
}