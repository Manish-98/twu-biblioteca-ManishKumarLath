package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class GetListOfMoviesTest {

    @Test
    public void testShouldDisplayListOfMoviesInLibrary() {
        Stream console = mock(Stream.class);
        Movie movieOne = new Movie("Movie1", 2020, "Director1", 7.5);
        Movie movieTwo = new Movie("Movie2", 2020, "Director2", 8);
        Collection<LibraryItems> movies = new ArrayList<>(Arrays.asList(movieOne, movieTwo));
        GetListOfMovies getListOfMovies = new GetListOfMovies(console, movies);

        getListOfMovies.execute();

        verify(console, times(1)).output("Movie1|2020|Director1|7.5\n" +
                "Movie2|2020|Director2|8.0\n");
    }
}