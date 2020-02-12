package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class GetListOfBooksTest {

    @Test
    public void testShouldDisplayBooksPresentInLibrary() {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Book bookTwo = new Book("Book2", "Author2", 2020);
        Collection<Book> books = new ArrayList<>(Arrays.asList(bookOne, bookTwo));
        GetListOfBooks getListOfBooks = new GetListOfBooks(console);

        getListOfBooks.execute(books);

        verify(console, times(1)).output("Book1|Author1|2020\n" +
                "Book2|Author2|2020\n");
    }


    @Test
    public void testShouldNotDisplayBooksCheckedOutOfLibrary() throws IOException {
        Stream console = mock(Stream.class);
        Book bookOne = new Book("Book1", "Author1", 2020);
        Book bookTwo = new Book("Book2", "Author2", 2020);
        Book bookThree = new Book("Book3", "Author3", 2020);
        Collection<Book> books = new ArrayList<>(Arrays.asList(bookOne, bookTwo, bookThree));
        when(console.input()).thenReturn("Book3");
        bookThree.checkout();
        GetListOfBooks getListOfBooks = new GetListOfBooks(console);

        getListOfBooks.execute(books);

        verify(console, times(1)).output("Book1|Author1|2020\n" +
                "Book2|Author2|2020\n");
    }
}