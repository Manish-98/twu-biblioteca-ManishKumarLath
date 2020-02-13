package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckoutMovieTest {

    @Test
    public void testShouldCheckoutMovieRequestedByUser() throws IOException {
        Stream console = mock(Stream.class);
        Movie movieOne = new Movie("Movie1", 2020, "Director1", 7.5);
        Movie movieTwo = new Movie("Movie2", 2020, "Director2", 7.5);
        Collection<LibraryItems> movies = new ArrayList<>(Arrays.asList(movieOne, movieTwo));
        when(console.input()).thenReturn("Movie1");
        CheckoutMovie checkoutMovie = new CheckoutMovie(console, movies);

        checkoutMovie.execute();

        assertTrue(movieOne.isCheckedOut());
        assertFalse(movieTwo.isCheckedOut());
    }

    @Test
    public void testShouldNotCheckoutMoviesNotInTheLibrary() throws IOException {
        Stream console = mock(Stream.class);
        Movie movieOne = new Movie("Movie1", 2020, "Director1", 7.5);
        Collection<LibraryItems> movies = new ArrayList<>(Collections.singletonList(movieOne));
        when(console.input()).thenReturn("Movie2");
        CheckoutMovie checkoutMovie = new CheckoutMovie(console, movies);

        checkoutMovie.execute();

        assertFalse(movieOne.isCheckedOut());
    }
}